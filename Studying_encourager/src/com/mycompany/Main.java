package com.mycompany;

import doryan.windowsnotificationapi.fr.Notification;

import java.awt.*;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        isNow(1);
    }
    public static void isNow(int q) {
        String a22;
        int u = 0;
        int f = 0;

        Date a = new Date();
        SimpleDateFormat a1 = new SimpleDateFormat("h:mm a");
        a22 = a(a1.format(a), q);
        for (; ; ) {
            a = new Date();
            a1 = new SimpleDateFormat("h:mm a");
            if (a1.format(a).equals(a22)) {
                if (u + q >= 60) {
                    u = u + q - 60;
                    f++;
                } else {
                    u = u + q;
                }
                try {
                    if (f == 0) {
                        Notification.sendNotification("keep going",  "You have been studying for "+u +" min.", TrayIcon.MessageType.INFO);
                    } else {
                        if (f == 1) {
                            if (u != 0) {
                                Notification.sendNotification("keep going", "You have been studying for 1h,"+u+"min.", TrayIcon.MessageType.INFO);
                            } else {
                                Notification.sendNotification("keep going", "You have been studying for 1h.", TrayIcon.MessageType.INFO);
                            }
                        } else if (f == 2) {
                            if (u != 0) {

                                    Notification.sendNotification("keep going", "You have been studying for 2h,"+u+"min.", TrayIcon.MessageType.INFO);

                            } else {
                                Notification.sendNotification("keep going", "You have been studying for 2h", TrayIcon.MessageType.INFO);
                            }
                        } else if (f > 2 && f <= 10) {
                            if (u != 0) {
                                Notification.sendNotification("keep going","You have been studying for "+f+"h,"+u+"min.", TrayIcon.MessageType.INFO);
                            } else {
                                Notification.sendNotification("keep going", "You have been studying for "+f+"h", TrayIcon.MessageType.INFO);
                            }
                        } else {
                            if (u != 0) {
                                if (u <= 10) {
                                    Notification.sendNotification("keep going","You have been studying for "+f+"h,"+u+"min.", TrayIcon.MessageType.INFO);
                                } else {
                                    Notification.sendNotification("keep going","You have been studying for "+f+"h,"+u+"min.", TrayIcon.MessageType.INFO);
                                }
                            } else {
                                Notification.sendNotification("keep going","You have been studying for "+f+"h,"+u+"min.", TrayIcon.MessageType.INFO);
                            }
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                a22 = a(a22, q);
                continue;
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String a(String a, int w) {
        int f;
        int g;
        String a1 = "";
        String a2 = "";
        String a3 = a.charAt(a.length() - 2) + "" + a.charAt(a.length() - 1);
        String a4;
        if (a.charAt(1) == ':') {
            a1 = a1 + a.charAt(0);
            a2 = a2 + a.charAt(2) + a.charAt(3);
        }
        if (a.charAt(2) == ':') {
            a1 = a1 + a.charAt(0) + a.charAt(1);
            a2 = a2 + a.charAt(3) + a.charAt(4);
        }

        f = Integer.parseInt(a1);
        g = Integer.parseInt(a2);
        if ((g + w) < 60) {
            g = g + w;
        } else {
            g = (g + w) - 60;
            f = f + 1;
        }
        if (String.valueOf(g).length() == 1) {
            a4 = (f + ":0" + g + " " + a3);
        } else {
            a4 = f + ":" + g + " " + a3;
        }
        return a4;
    }
}
