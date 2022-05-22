package ru.gb.alekseev.game15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Puzzle15Window extends JFrame {

    static final int PUZZLE_FIELD_LENGTH = 400;
    static final int HEADER_HEIGHT = 32;
    static final int RANDOMIZE_BUTTON_WIDTH = 120;

    public Puzzle15Window() {
        setTitle("15 Puzzle");
        //TODO выяснить, почему кнопки не умещаются, если размеры поставить точно setBounds(300, 300, PUZZLE_FIELD_LENGTH, PUZZLE_FIELD_LENGTH + HEADER_HEIGHT);
        setBounds(300, 300, PUZZLE_FIELD_LENGTH + 16, PUZZLE_FIELD_LENGTH + HEADER_HEIGHT + 38);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //initializing game
        game = new Puzzle15Game();
        game.setActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command  = e.getActionCommand();
                if (Puzzle15Game.CHANGED_COMMAND_NAME.equals(command))
                {
                    updateView();
                }
            }
        });

        setLayout(null);

        //creating randomize button
        JButton randomizeButton = new JButton("Randomize");
        randomizeButton.setBounds(0, 0, RANDOMIZE_BUTTON_WIDTH, HEADER_HEIGHT);
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.randomize();
            }
        });
        add(randomizeButton);

        //creating description field
        stateDescriptionLabel = new JLabel();
        stateDescriptionLabel.setBounds(RANDOMIZE_BUTTON_WIDTH, 0, getWidth() - RANDOMIZE_BUTTON_WIDTH - 2, HEADER_HEIGHT);
        stateDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add (stateDescriptionLabel);

        //creating game panel
        JPanel puzzlePanel = new JPanel();
        add(puzzlePanel);
        puzzlePanel.setBounds(0, HEADER_HEIGHT, PUZZLE_FIELD_LENGTH, PUZZLE_FIELD_LENGTH);
        puzzlePanel.setLayout(new GridLayout(4, 4));

        //creating buttons
        buttons = new JButton[16];
        Font font = new Font("Arial", Font.BOLD, 32);
        for ( int i = 0; i<16; i++){
            JButton button = new JButton("-");
            button.setFont(font);
            buttons[i] = button;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton senderButton = (JButton)e.getSource();
                    int chipNumber = Integer.parseInt(senderButton.getText());
                    game.makeStep(chipNumber);
                }
            });
            puzzlePanel.add(button);
        }
        updateView();
    }

    JLabel stateDescriptionLabel;
    private Puzzle15Game game;
    private JButton[] buttons;

    private void updateView() {
        stateDescriptionLabel.setText(game.getDescription());

        for (int i = 0; i < 16; i++) {
            JButton button = buttons[i];
            int chipNumber = game.getChipNumber(i);
            button.setText(String.valueOf(chipNumber));
            button.setVisible(chipNumber != Puzzle15Game.ABSENT_CHIP_NUMBER);
        }
    }
}


