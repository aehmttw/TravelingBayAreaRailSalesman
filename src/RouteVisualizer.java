import lwjglwindow.IDrawer;
import lwjglwindow.IUpdater;
import lwjglwindow.LWJGLWindow;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.Scanner;

public class RouteVisualizer implements IUpdater, IDrawer
{
    public RailGraph railGraph;
    public LWJGLWindow window;
    public ArrayList<String> itinerary;
    public ArrayList<Line.Stop> stops = new ArrayList<>();
    public ArrayList<String> times = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (true)
        {
            String s = scan.nextLine();
            if (s.contains("quit"))
                break;

            input.add(s);
        }

        RouteVisualizer v = new RouteVisualizer(input);
        v.window = new LWJGLWindow("Rail Grapher", 1400, 900, v, v, true);
        v.window.run();
    }

    public RouteVisualizer(ArrayList<String> input)
    {
        this.railGraph = new RailGraph();
        this.railGraph.init();
        this.itinerary = input;

        for (String s: itinerary)
        {
            String time = s.split(" ")[0];
            String data = s.split("\\)")[1];
            String lineName = data.substring(data.lastIndexOf("/") + 1);
            String stationName = data.substring(0, data.lastIndexOf("/"));
            Line l = Line.linesByName.get(lineName);
            stops.add(l.stopsByStation.get(Station.stationsByName.get(stationName)));
            times.add(time);
        }

        current = stops.get(0);
        next = current;
        officialStopNum = current.officialStopIndex;
    }

    public double zoom = 657;
    public double centerX = -122.01;
    public double centerY = -37.51;

    public int stopIndex = -1;
    public Line.Stop current;
    public Line.Stop next;
    public int officialStopNum;

    public double time = 0;
    public boolean autoplay = false;

    @Override
    public void update()
    {
        double mul = 5;
        double freq = window.frameFrequency;
        time += freq;

        if (window.pressedKeys.contains(GLFW.GLFW_KEY_RIGHT) || window.pressedKeys.contains(GLFW.GLFW_KEY_D))
            centerX += freq / zoom * mul;

        if (window.pressedKeys.contains(GLFW.GLFW_KEY_LEFT) || window.pressedKeys.contains(GLFW.GLFW_KEY_A))
            centerX -= freq / zoom * mul;

        if (window.pressedKeys.contains(GLFW.GLFW_KEY_DOWN) || window.pressedKeys.contains(GLFW.GLFW_KEY_S))
            centerY += freq / zoom * mul;

        if (window.pressedKeys.contains(GLFW.GLFW_KEY_UP) || window.pressedKeys.contains(GLFW.GLFW_KEY_W))
            centerY -= freq / zoom * mul;

        if (window.pressedKeys.contains(GLFW.GLFW_KEY_EQUAL))
            zoom *= Math.pow(1.05, freq);

        if (window.pressedKeys.contains(GLFW.GLFW_KEY_MINUS))
            zoom *= Math.pow(0.95, freq);

        if (window.validPressedKeys.contains(GLFW.GLFW_KEY_ENTER))
        {
            time = 0;
            autoplay = !autoplay;
            window.validPressedKeys.remove((Integer) GLFW.GLFW_KEY_ENTER);
        }

        if (window.validPressedKeys.contains(GLFW.GLFW_KEY_SPACE) || (autoplay && time > 10))
        {
            time = 0;
            window.validPressedKeys.remove((Integer) GLFW.GLFW_KEY_SPACE);

            if (officialStopNum == next.officialStopIndex)
            {
                if (stopIndex + 1 < stops.size())
                {
                    stopIndex++;
                    current = stops.get(stopIndex);

                    if (stopIndex + 1 < stops.size())
                    {
                        next = current.line.stopsByStation.get(stops.get(stopIndex + 1).station);
                        officialStopNum = current.officialStopIndex;
                    }
                }
            }
            else
                officialStopNum += Math.signum(next.officialStopIndex - current.officialStopIndex);

            current.line.officialStops.get(officialStopNum).explored = true;
            centerX = current.line.officialStops.get(officialStopNum).longitude;
            centerY = -current.line.officialStops.get(officialStopNum).latitude;
        }
    }

    @Override
    public void draw()
    {
        window.setColor(80, 80, 80);
        window.fillRect(0, 0, window.absoluteWidth, window.absoluteHeight);

        plotLines(14);

        window.setColor(255, 255, 255);
        window.fontRenderer.drawString(20, 20, 0.25, 0.25, String.format("%.5f, %.5f, %.3f", centerX, centerY, zoom));

        for (int i = 0; i <= stopIndex; i++)
        {
            Line.Stop s = stops.get(i);
            window.setColor(s.line.colorR, s.line.colorG, s.line.colorB);
            window.fontRenderer.drawString(20, 35 + 12 * i, 0.25, 0.25,  times.get(i) + ": " + s.station.name + " -> " + s.line.name);
        }
    }

    public void plotLines(double size)
    {
        double mul = 0.25;
        for (int ex = 0; ex < 2; ex++)
        {
            for (Line l: Line.lines)
            {
                boolean explored = ex == 1;
                if (ex == 1)
                    mul = 1;

                window.setColor(l.colorR * mul, l.colorG * mul, l.colorB * mul);
                for (int i = 1; i < l.officialStops.size(); i++)
                {
                    Line.OfficialStop s1 = l.officialStops.get(i - 1);
                    Line.OfficialStop s2 = l.officialStops.get(i);

                    if ((s1.explored && s2.explored) == explored)
                        plotLine(s1.longitude, s1.latitude, s2.longitude, s2.latitude, size / 2);
                }

                window.setColor((l.colorR + 255.0) / 2 * mul, (l.colorG + 255.0) / 2 * mul, (l.colorB + 255.0) / 2 * mul);
                for (Line.OfficialStop s : l.officialStops)
                {
                    if (s.explored == explored)
                        plotPoint(s.longitude, s.latitude, size);
                }

                window.setColor(255 * mul, 255 * mul, 255 * mul);
                for (Line.OfficialStop s : l.officialStops)
                {
                    if (s.explored == explored)
                        plotPoint(s.longitude, s.latitude, size * 0.6);
                }
            }
        }

        if (zoom > 2000)
        {
            window.setColor(255, 255, 255, Math.min((zoom - 2000) / 2000, 1) * 255);

            for (Line l : Line.lines)
            {
                for (Line.OfficialStop s : l.officialStops)
                {
                    if (!s.explored)
                        continue;

                    if (s.stopIndex < 0)
                        plotText(s.name, s.longitude, s.latitude, 0.25, 0);
                    else
                        plotText(s.name, s.longitude, s.latitude, 0.4, -6);
                }
            }

            for (int i = 0; i <= stopIndex; i++)
            {
                Line.OfficialStop os = stops.get(i).line.officialStops.get(stops.get(i).officialStopIndex);
                plotText(times.get(i), os.longitude, os.latitude, 0.25, 6);
            }
        }
    }

    public void plotPoint(double x, double y, double size)
    {
        window.fillOval(window.absoluteWidth / 2.0 + (-centerX + x) * zoom - size / 2, window.absoluteHeight / 2.0 + (-centerY - y) * zoom - size / 2, size, size);
    }

    public void plotLine(double x, double y, double x1, double y1, double size)
    {
        window.fillLine(window.absoluteWidth / 2.0 + (-centerX + x) * zoom, window.absoluteHeight / 2.0 + (-centerY - y) * zoom,
                window.absoluteWidth / 2.0 + (-centerX + x1) * zoom, window.absoluteHeight / 2.0 + (-centerY - y1) * zoom, size);
    }

    public void plotText(String text, double x, double y, double size, double offset)
    {
        double x1 = window.absoluteWidth / 2.0 + (-centerX + x) * zoom + 12;
        double y1 = window.absoluteHeight / 2.0 + (-centerY - y) * zoom - 12 * size;
        double width = window.fontRenderer.getStringSizeX(size, text);

        if (x1 < -width || x1 > window.absoluteWidth || y1 < 0 || y1 > window.absoluteHeight)
            return;

        window.fontRenderer.drawString(x1, y1 + offset, size, size, text);
    }
}
