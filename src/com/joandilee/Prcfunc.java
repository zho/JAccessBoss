package com.joandilee;

import java.io.*;
import javax.swing.JOptionPane;

public class Prcfunc {

    public void process() {
        /*
         * Day Abbrevation on windows' net send
         * Su = Sunday
         * M = Monday
         * T = Tuesday
         * W = Wednesday
         * Th = Thursday
         * F = Friday
         * S = Saturday
         */
        String sun = "";
        String mon = "";
        String tue = "";
        String wed = "";
        String thu = "";
        String fri = "";
        String sat = "";
        // Sunday
        for (int a = 0; a <= 23; a++) {
            if (Maingui.status[a][0] == 1) {
                sun = sun + "Su," + a + ";";
            }
        }
        // Monday
        for (int a = 0; a <= 23; a++) {
            if (Maingui.status[a][1] == 1) {
                mon = mon + "M," + a + ";";
            }
        }
        // Tuesday
        for (int a = 0; a <= 23; a++) {
            if (Maingui.status[a][2] == 1) {
                tue = tue + "T," + a + ";";
            }
        }
        // Wednesday
        for (int a = 0; a <= 23; a++) {
            if (Maingui.status[a][3] == 1) {
                wed = wed + "W," + a + ";";
            }
        }
        // Thursday
        for (int a = 0; a <= 23; a++) {
            if (Maingui.status[a][4] == 1) {
                thu = thu + "Th," + a + ";";
            }
        }
        // Friday
        for (int a = 0; a <= 23; a++) {
            if (Maingui.status[a][5] == 1) {
                fri = fri + "F," + a + ";";
            }
        }
        // Saturday
        for (int a = 0; a <= 23; a++) {
            if (Maingui.status[a][6] == 1) {
                sat = sat + "S," + a + ";";
            }
        }
        String allproc = "";
        allproc = allproc + sun + mon + tue + wed + thu + fri + sat;
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("net users " + Maingui.uname.getText() + " /times:" + allproc);
        } catch (IOException e1) {
        }
    }

    public void savedata(String namafile) {
        int a, b;
        try {
            FileWriter fw = new FileWriter(namafile + ".txt", false);
            fw.flush();
            for (a = 0; a <= 23; a++) {
                for (b = 0; b <= 6; b++) {
                    fw.write(Integer.toString(Maingui.status[a][b]));
                }
            }
            fw.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public String loaddata(String namafile) {
        String dodol = null;
        try {
            BufferedReader bfread = new BufferedReader(new FileReader(namafile + ".txt"));
            dodol = bfread.readLine();
            //JOptionPane.showMessageDialog(null, dodol);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Username Not Exist or never set any Login Hour with this program", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
        }
        return dodol;
    }
}
