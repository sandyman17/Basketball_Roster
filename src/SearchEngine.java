import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    public static void main(String args[]) throws IOException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        String input = scanner.nextLine();
        System.out.println("Enter output: ");
        String output = scanner.nextLine();

        File f1  = new File(input);
        File f2 = new File(output);
        if (!f1.exists()) {
            throw new FileNotFoundException();
        }
        if (!f2.exists()) {
            throw new FileNotFoundException();
        }

        PlayerList pl = readFile(input);
        ArrayList<Player> al = findPLayer(pl);
        writeFile(al, output);

    }

    public static PlayerList readFile(String fileName) throws IOException, FileNotFoundException  {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        //System.out.println(file.exists());

        if (file.exists()) {
            ArrayList<Player> players = new ArrayList<Player>();

            for (int i = 0; sc.hasNextLine(); i++) {

                String[] p = sc.nextLine().split(" ");
                String Line =  " ";

                for(int j = 9; j < p.length; j++) {
                    Line += p[j];
                }
                Line.trim();
                String[] skills = Line.split(",");
                ArrayList<String> skillz = new ArrayList<String>();
                for (int j = 0; j < skills.length; j ++) {
                    skillz.add(skills[j]);
                }
                players.add(new Player(p[0], p[1], p[2], Integer.parseInt(p[3]), Integer.parseInt(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]), Integer.parseInt(p[7]), Integer.parseInt(p[8]), skillz));
            }
            return new PlayerList(players);
        }
        else {
            throw new FileNotFoundException();
        }
    }

    public static void writeFile(ArrayList<Player> startup, String output) throws IOException {
        File f = new File(output);
        f.createNewFile();
        PrintWriter pw = new PrintWriter(new FileOutputStream(f));
        for (int i = 0; i < startup.size(); i ++) {
            String firstName = startup.get(i).getFirstName();
            pw.write(firstName);
            String lastName = startup.get(i).getLastName();
            pw.write(lastName);
            String pos = startup.get(i).getPosition();
            pw.write(pos);
            int totalAtt = startup.get(i).getTotalAttribute();
            pw.write(totalAtt + "\n");
        }

    }

    public static ArrayList<Player> findPLayer(PlayerList list) {

        ArrayList<Player> startup = new ArrayList<Player>();

        startup.add(list.findPG());
        startup.add(list.findSG());
        startup.add(list.findSF());
        startup.add(list.findPF());
        startup.add(list.findC());

        return startup;
    }
}
