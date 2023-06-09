package afafi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CombatWindow extends JFrame{

    private JPanel contentPane;
    private int playerHP = 30;
    private int monsterHP = 70;
    private String[] monster;


    public CombatWindow(String[] monster){
        setTitle("AFAFI - Combat");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400, 400, 800, 600);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JProgressBar playerHPbar = new JProgressBar(0, 100);
        playerHPbar.setValue(playerHP);
        playerHPbar.setForeground(new Color(255, 0, 0));
        playerHPbar.setBounds(25, 25, 250, 15);
        playerHPbar.setStringPainted(true);
        playerHPbar.setString(playerHP +"/"+ 100);
        contentPane.add(playerHPbar);


        JProgressBar monsterHPbar = new JProgressBar(0, Integer.parseInt(monster[1]));
        monsterHPbar.setValue(monsterHP);
        monsterHPbar.setForeground(new Color(255, 0, 0));
        monsterHPbar.setBounds(510, 25, 250, 15);
        monsterHPbar.setStringPainted(true);
        monsterHPbar.setString(monsterHP +"/"+ Integer.parseInt(monster[1]));
        contentPane.add(monsterHPbar);

        JLabel playerIcon = new JLabel();
        playerIcon.setBackground(new Color(255, 255, 255));
        playerIcon.setOpaque(true); //TODO REMOVE
        playerIcon.setHorizontalAlignment(SwingConstants.CENTER);
        playerIcon.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        playerIcon.setBounds(25, 50, 250, 250);
        contentPane.add(playerIcon);

        JLabel monsterIcon = new JLabel();
        monsterIcon.setBackground(new Color(255, 255, 255));
        monsterIcon.setOpaque(true); //TODO REMOVE
        monsterIcon.setHorizontalAlignment(SwingConstants.CENTER);
        monsterIcon.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        monsterIcon.setBounds(510, 50, 250, 250);
        contentPane.add(monsterIcon);


        JLabel playerName = new JLabel("Kox", SwingConstants.CENTER);
        playerName.setFont(new Font("Tahoma", Font.BOLD, 14));
        playerName.setForeground(new Color(159, 67, 67));
        playerName.setBounds(25, 299, 250, 25);
        playerName.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        playerName.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(playerName);

        JLabel monsterName = new JLabel(monster[0], SwingConstants.CENTER);
        monsterName.setFont(new Font("Tahoma", Font.BOLD, 14));
        monsterName.setForeground(new Color(218, 98, 98));
        monsterName.setBounds(510, 299, 250, 25);
        monsterName.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        monsterName.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(monsterName);

        JLabel monsterAtk = new JLabel("Attack: "+monster[2], SwingConstants.CENTER);
        monsterAtk.setFont(new Font("Tahoma", Font.BOLD, 14));
        monsterAtk.setForeground(new Color(218, 98, 98));
        monsterAtk.setBounds(510, 323, 250, 25);
        monsterAtk.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        monsterAtk.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(monsterAtk);

        JLabel monsterDef = new JLabel("Defence: "+monster[3], SwingConstants.CENTER);
        monsterDef.setFont(new Font("Tahoma", Font.BOLD, 14));
        monsterDef.setForeground(new Color(218, 98, 98));
        monsterDef.setBounds(510, 347, 250, 25);
        monsterDef.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        monsterDef.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(monsterDef);






    }
}
