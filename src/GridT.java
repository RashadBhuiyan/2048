package src;

import src.Direction;
import src.TileT;
/**
 * @file: GridT.java
 * @Author: Rashad Ahmed Bhuiyan - bhuiyr2
 * @Date: 2021-04-12
 * @Description: defines the grid that will contain the tiles for the game.
 */
public class GridT
{
    public TileT[][] gridState;
    int Size = 4;
    int edgeOfGrid = 0;
    public int score = 0;

    /** 
     * @brief constructor
     */
    public GridT()
    {
        gridState = new TileT[Size][Size];
        for ( int i = 0; i < Size; i++ )
        {
            for ( int j = 0; j < Size; j++ )
            {
                gridState[i][j] = new TileT();
            }
        }
    }

    /**
     * @brief public instance method to obtain the 2D matrix for this grid 
     * @return the 2-dimensional set of TileT objects that make up this grid
     */
    public TileT[][] getGrid()
    {
        return gridState;
    }

    /**
     * @brief public instance method to obtain a string representation of this GridT object
     * @return the string representation of the 2-dimensional set of TileT objects in this GridT object
     */
    public String toString()
    {
        String s = "";
        for ( int i = 0; i < Size; i++ )
        {
            for ( int j = 0; j < Size; j++ )
            {
                s += gridState[i][j].toString() + " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * @brief public instance method that generates a tile in a random empty place of a random value (either 2 or 4)
     */
    public void genRandomTile()
    {
        boolean empty = true;
        while (empty)
        {
            int row = (int)(Math.random() * 4);
            int col = (int)(Math.random() * 4);
            double x = Math.random();
            if (gridState[row][col].getValue() == 0)
            {
                if (x < 0.2)
                {
                    gridState[row][col] = new TileT(4);
                    empty = false;
                }
                else
                {
                    gridState[row][col] = new TileT(2);
                    empty = false;
                }
            }
        }
    }

    /**
     * @brief public instance method to obtain the score for this game on this GridT object
     * @return the score for this game
     */
    public int getScore()
    {
        return score;
    }

    /**
     * @brief public instance method to check whether all the squares are occupied to hint the user to restart
     * @return whether every tile has a nonzero value
     */
    public boolean checkRestart()
    {
        int count = 0;
        for (int i = 0; i < gridState.length; i++)
        {
            for (int j = 0; j < gridState[i].length; j++)
            {
                if (gridState[i][j].getValue() > 0)
                {
                    count++;
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
    }

    /**
     * @brief public instance method to check whether it is possible to make a move
     * @return whether a move is possible
     */
    public boolean checkGameOver()
    {
        int count = 0;
        for ( int i = 0; i < gridState.length; i++ )
        {
            for ( int j = 0; j < gridState[i].length; j++ )
            {
                if ( gridState[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( gridState[i][j].getValue() != gridState[i + 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 3 )
                    {
                        if ( gridState[i][j].getValue() != gridState[i + 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 3 )
                    {
                        if ( gridState[i][j].getValue() != gridState[i - 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 0 )
                    {
                        if ( gridState[i][j].getValue() != gridState[i - 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 ) )
                    {
                        if ( gridState[i][j].getValue() != gridState[i + 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i][j + 1].getValue()
                            && gridState[i][j].getValue() != gridState[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && ( j == 1 || j == 2 ) )
                    {
                        if ( gridState[i][j].getValue() != gridState[i - 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i][j + 1].getValue()
                            && gridState[i][j].getValue() != gridState[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 ) )
                    {
                        if ( gridState[i][j].getValue() != gridState[i][j + 1].getValue()
                            && gridState[i][j].getValue() != gridState[i - 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 3 && ( i == 1 || i == 2 ) )
                    {
                        if ( gridState[i][j].getValue() != gridState[i][j - 1].getValue()
                            && gridState[i][j].getValue() != gridState[i - 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( gridState[i][j].getValue() != gridState[i][j - 1].getValue()
                            && gridState[i][j].getValue() != gridState[i][j + 1].getValue()
                            && gridState[i][j].getValue() != gridState[i - 1][j].getValue()
                            && gridState[i][j].getValue() != gridState[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
    }

    /**
     * @brief public instance method to move every TileT object up if possible
     */
    public void moveUp()
    {
        for (int i = 0; i < Size; i++)
        {
            edgeOfGrid = 0;
            for (int j = 0; j < Size; j++)
            {
                if (gridState[j][i].getValue() != 0)
                {
                    if (edgeOfGrid <= j)
                    {
                        verticalMove(j, i, Direction.Up);
                    }
                }
            }
        }
    }

    /**
     * @brief public instance method to move every TileT object down if possible
     */
    public void moveDown()
    {
        for (int i = 0; i < Size; i++)
        {
            edgeOfGrid = (Size - 1);
            for (int j = Size - 1; j >= 0; j--)
            {
                if (gridState[j][i].getValue() != 0)
                {
                    if (edgeOfGrid >= j)
                    {
                        verticalMove( j, i, Direction.Down);
                    }
                }
            }
        }
    }

    /**
     * @brief private instance method to move every TileT object in the vertical direction specified
     * @param row the row of the TileT object
     * @param col the column of the TileT object
     * @param direction the direction which the TileT objects will be travelling
     */
    private void verticalMove( int row, int col, Direction direction )
    {
        TileT initial = gridState[edgeOfGrid][col];
        TileT compare = gridState[row][col];
        if (initial.getValue() == 0 || initial.getValue() == compare.getValue())
        {
            if (row > edgeOfGrid || (direction.equals(Direction.Down) && (row < edgeOfGrid)))
            {
                int addScore = initial.getValue() + compare.getValue();
                if (initial.getValue() != 0)
                {
                    score += addScore;
                }
                initial.setValue(addScore);
                compare.setValue(0);
            }
        }
        else
        {
            if (direction.equals(Direction.Down))
            {
                edgeOfGrid--;
            }
            else
            {
                edgeOfGrid++;
            }
            verticalMove(row, col, direction);
        }
    }

    /**
     * @brief public instance method to move every TileT object left if possible
     */
    public void moveLeft()
    {
        for (int i = 0; i < Size; i++)
        {
            edgeOfGrid = 0;
            for (int j = 0; j < Size; j++)
            {
                if (gridState[i][j].getValue() != 0)
                {
                    if (edgeOfGrid <= j)
                    {
                        horizontalMove(i, j, Direction.Left);
                    }
                }
            }
        }
    }

    /**
     * @brief public instance method to move every TileT object right if possible
     */
    public void moveRight()
    {
        for (int i = 0; i < Size; i++)
        {
            edgeOfGrid = (Size - 1);
            for (int j = ( Size - 1 ); j >= 0; j--)
            {
                if (gridState[i][j].getValue() != 0)
                {
                    if (edgeOfGrid >= j)
                    {
                        horizontalMove(i, j, Direction.Right);
                    }
                }
            }
        }
    }

    /**
     * @brief private instance method to move every TileT object in the horizontal direction specified
     * @param row the row of the TileT object
     * @param col the column of the TileT object
     * @param direction the direction which the TileT objects will be travelling
     */
    private void horizontalMove(int row, int col, Direction direction)
    {
        TileT initial = gridState[row][edgeOfGrid];
        TileT compare = gridState[row][col];
        if (initial.getValue() == 0 || initial.getValue() == compare.getValue())
        {
            if (col > edgeOfGrid || (direction.equals(Direction.Right) && (col < edgeOfGrid)))
            {
                int addScore = initial.getValue() + compare.getValue();
                if (initial.getValue() != 0)
                {
                    score += addScore;
                }
                initial.setValue(addScore);
                compare.setValue(0);
            }
        }
        else
        {
            if (direction.equals(Direction.Right))
            {
                edgeOfGrid--;
            }
            else
            {
                edgeOfGrid++;
            }
            horizontalMove(row, col, direction);
        }
    }

}
