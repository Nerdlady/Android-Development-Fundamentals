package com.example.homeworktwo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends Activity implements OnClickListener {

    private static final char[] PLAYERS = {'X','O'};

    private TextView playerMove;
    private TextView scoreView;
    private int[][] table;
    private String[] players;
    private int currentPlayer;
    private int playerOneWins;
    private int playerTwoWins;
    private Button[] gameButtons;
    private Button playAgainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.tic_tac_toe);
        this.playerMove = (TextView) this.findViewById(R.id.playerMove);
        this.scoreView = (TextView) this.findViewById(R.id.scoreTextView);
        this.table = new int[3][3];
        this.players = new String[]{"One", "Two"};
        this.currentPlayer = 0;
        this.fillButtonds();
        this.setTable();
        this.playAgainButton = (Button) this.findViewById(R.id.playAgainButton);
        this.playAgainButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int row;
        int col;
        Button button;
        switch (v.getId()){
            case R.id.button:
                row = 0;
                col = 0;
                button = this.gameButtons[0];
                break;
            case R.id.button2:
                row = 0;
                col = 1;
                button = this.gameButtons[1];
                break;
            case R.id.button3:
                row = 0;
                col = 2;
                button = this.gameButtons[2];
                break;
            case R.id.button4:
                row = 1;
                col = 0;
                button = this.gameButtons[3];
                break;
            case R.id.button5:
                row = 1;
                col = 1;
                button = this.gameButtons[4];
                break;
            case R.id.button6:
                row = 1;
                col = 2;
                button = this.gameButtons[5];
                break;
            case R.id.button7:
                row = 2;
                col = 0;
                button = this.gameButtons[6];
                break;
            case R.id.button8:
                row = 2;
                col = 1;
                button = this.gameButtons[7];
                break;
            case R.id.button9:
                row = 2;
                col = 2;
                button = this.gameButtons[8];
                break;
            case R.id.playAgainButton:
                this.reloadGame();
                return;
            default:
                return;
        }
        button.setText( String.format("%s",PLAYERS[currentPlayer]));
        this.table[row][col] = currentPlayer;
        button.setEnabled(false);

        if (checkForWin()){
            this.playerMove.setText(String.format("%s WIN",players[currentPlayer]));
            this.disenableButtons();
            if (currentPlayer == 0){
                this.playerOneWins++;
            } else {
                playerTwoWins++;
            }
            this.scoreView.setText(String.format("Score: %d:%d",this.playerOneWins,this.playerTwoWins));
        } else {
            this.playerMove.setText(String.format("%s",players[currentPlayer]));
        }

    }

    private void disenableButtons() {
        for (Button button : gameButtons) {
            button.setEnabled(false);
        }
    }

    private void reloadGame() {
        this.setTable();
        for (Button button : gameButtons) {
            button.setText(String.format(" "));
            button.setEnabled(true);
        }
    }

    private boolean checkForWin(){
        for (int i = 0; i < this.table.length; i++) {
            if ((this.table[i][0] == this.table[i][1] && this.table[i][0] == this.table[i][2]) && this.table[i][0] != -1){
                return true;
            }
        }

        for (int i = 0; i < this.table[0].length; i++) {
            if ((this.table[0][i] == this.table[1][i] && this.table[0][i] == this.table[2][i]) && this.table[0][i] != -1){
                return true;
            }
        }

        if (((this.table[0][0] == this.table[1][1] && this.table[0][0] == this.table[2][2])
                || ( (this.table[0][2] == this.table[1][1] && this.table[0][2] == this.table[2][0])))
                && this.table[1][1] != -1){
            return true;
        }

        this.currentPlayer = (currentPlayer + 1) % PLAYERS.length;
        return false;
    }

    private void fillButtonds() {
        Button one = (Button) this.findViewById(R.id.button);
        Button two = (Button) this.findViewById(R.id.button2);
        Button three = (Button) this.findViewById(R.id.button3);
        Button four = (Button) this.findViewById(R.id.button4);
        Button five = (Button) this.findViewById(R.id.button5);
        Button six = (Button) this.findViewById(R.id.button6);
        Button seven = (Button) this.findViewById(R.id.button7);
        Button eight = (Button) this.findViewById(R.id.button8);
        Button nine = (Button) this.findViewById(R.id.button9);

        this.gameButtons = new Button[]{one, two, three, four, five, six, seven, eight, nine};
        for (int i = 0; i < gameButtons.length; i++) {
            gameButtons[i].setOnClickListener(this);
        }
    }

    private void setTable() {
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[i].length; j++) {
                this.table[i][j] = -1;
            }
        }
    }
}
