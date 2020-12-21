package InlämningsUppgiftVG;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SantaClausWorkShop {

    protected List<String> input = readFileString("src/InlämningsUppgiftVG/santaClausHierarchy.txt");

    protected final ImageIcon santaClaus = new ImageIcon("src/InlämningsUppgiftVG/Angry-SantaClaus.png");
    protected final ImageIcon mrsSanta = new ImageIcon("src/InlämningsUppgiftVG/MrsClaus.jpg");

    protected List<String> bosses = new ArrayList<>();
    protected List<String> subBosses = new ArrayList<>();

    protected String inputName = "";
    protected Boolean running = true;

    public static void main(String[] args) {
        new SantaClausWorkShop();
    }

    public SantaClausWorkShop() {
        while (running) {
            Choice choice = (Choice) JOptionPane.showInputDialog(null,
                    "Chose what you wanna get information about:\n\"Mega Boss\"\n\"Bosses\"\n\"Sub-bosses\"",
                    "SantaClausHierarchy", JOptionPane.QUESTION_MESSAGE, santaClaus, Choice.values(), Choice.values()[0]);
            switch (choice) {
                case MEGABOSS -> getMrsSanta();
                case BOSSES -> getBosses();
                case SUBBOSSES -> getSubBosses();
            }
        }

    }

    public void getBosses() {
        String name = JOptionPane.showInputDialog(null,
                "Input the name of the santa, to get the bosses: ",
                "Bosses", JOptionPane.INFORMATION_MESSAGE);

        inputName = name.substring(0, 1).toUpperCase() + name.substring(1);
        List<String> result = findBosses(name);

        if (result.size() == 0) {
            getMrsSanta();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : result) {
                sb.append(s);
                sb.append("\n");
            }
            JOptionPane.showMessageDialog(null,
                    "Bosses: \n" + sb.toString(),
                    "Sub-boss: " + inputName, JOptionPane.INFORMATION_MESSAGE);

            running = false;
        }

    }

    // recursive method
    public List<String> findBosses(String name) {
        for (String lines : input) {
            String[] lineSplit = lines.split(" ");
            String bossName = lineSplit[0];
            String allSubBosses = lines.substring(bossName.length() + 1);
            String[] subBoss = allSubBosses.split(" ");
            for (String s : subBoss) {
                if (s.equalsIgnoreCase(name)) {
                    bosses.add(0, bossName);
                    findBosses(bossName);
                }
            }
        }
        return bosses;
    }

    public void getSubBosses() {
        String name = JOptionPane.showInputDialog(null,
                "Input the name of the santa, to get the sub-bosses: ",
                "Sub-bosses", JOptionPane.INFORMATION_MESSAGE);

        inputName = name.substring(0, 1).toUpperCase() + name.substring(1);
        List<String> result = findSubBosses(name);

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null,
                    inputName + " has no sub-bosses, he is at the bottom of the pack!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : result) {
                sb.append(s);
                sb.append("\n");
            }
            JOptionPane.showMessageDialog(null,
                    "Sub-bosses: \n" + sb.toString(),
                    "Boss: " + inputName, JOptionPane.INFORMATION_MESSAGE);

            running = false;
        }
    }

    // recursive method
    public List<String> findSubBosses(String name) {
        for (String lines : input) {
            String[] lineSplit = lines.split(" ");
            String bossName = lineSplit[0];
            String allSubBosses = lines.substring(bossName.length() + 1);
            String[] subBoss = allSubBosses.split(" ");
            if (name.equalsIgnoreCase(bossName)) {
                for (String s : subBoss) {
                    subBosses.add(s);
                    findSubBosses(s);
                }
            }
        }
        return subBosses;
    }

    public void getMrsSanta() {
        JOptionPane.showMessageDialog(null, "",
                "Santa Claus's BOSS!", JOptionPane.WARNING_MESSAGE, mrsSanta);
    }

    public static List<String> readFileString(String location) {
        List<String> inputLines = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(location));
            while (sc.hasNextLine()) {
                inputLines.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputLines;
    }

}
