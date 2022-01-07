package src;

import src.Direction;

import java.awt.Color;
/**
 * @file: TileT.java
 * @Author: Rashad Ahmed Bhuiyan - bhuiyr2
 * @Date: 2021-04-12
 * @Description: defines a Tile in the game 2048.
 */
public class TileT
{
    int value;
    Color tileColour;
    Color[] COLOUR_WHEEL = new Color[11];

    /** 
     * @brief constructor
     */
    public TileT()
    {
        value = 0;
        for(int i = 0; i < COLOUR_WHEEL.length; i++)
        {
            switch(i)
            {
                case 0:
                    COLOUR_WHEEL[i] = new Color(238, 228, 218);
                    break;
                case 1:
                    COLOUR_WHEEL[i] = new Color(237, 224, 200);
                    break;
                case 2:
                    COLOUR_WHEEL[i] = new Color(242, 177, 121);
                    break;
                case 3:
                    COLOUR_WHEEL[i] = new Color(245, 149, 99);
                    break;
                case 4:
                    COLOUR_WHEEL[i] = new Color(246, 124, 95);
                    break;
                case 5:
                    COLOUR_WHEEL[i] = new Color(246, 94, 59);
                    break;
                case 6:
                    COLOUR_WHEEL[i] = new Color(237, 207, 114);
                    break;
                case 7:
                    COLOUR_WHEEL[i] = new Color(237, 204, 97);
                    break;
                case 8:
                    COLOUR_WHEEL[i] = new Color(237, 200, 80);
                    break;
                case 9:
                    COLOUR_WHEEL[i] = new Color(237, 197, 63);
                    break;
                case 10:
                    COLOUR_WHEEL[i] = new Color(237, 194, 46);
                    break;
            }
        }
    }

    /** 
     * @brief constructor
     * @param number the value of the Tile
     */
    public TileT(int number)
    {
        value = number;
        for(int i = 0; i < COLOUR_WHEEL.length; i++)
        {
            switch(i)
            {
                case 0:
                    COLOUR_WHEEL[i] = new Color(238, 228, 218);
                    break;
                case 1:
                    COLOUR_WHEEL[i] = new Color(237, 224, 200);
                    break;
                case 2:
                    COLOUR_WHEEL[i] = new Color(242, 177, 121);
                    break;
                case 3:
                    COLOUR_WHEEL[i] = new Color(245, 149, 99);
                    break;
                case 4:
                    COLOUR_WHEEL[i] = new Color(246, 124, 95);
                    break;
                case 5:
                    COLOUR_WHEEL[i] = new Color(246, 94, 59);
                    break;
                case 6:
                    COLOUR_WHEEL[i] = new Color(237, 207, 114);
                    break;
                case 7:
                    COLOUR_WHEEL[i] = new Color(237, 204, 97);
                    break;
                case 8:
                    COLOUR_WHEEL[i] = new Color(237, 200, 80);
                    break;
                case 9:
                    COLOUR_WHEEL[i] = new Color(237, 197, 63);
                    break;
                case 10:
                    COLOUR_WHEEL[i] = new Color(237, 194, 46);
                    break;
            }
        }
    }

    /**
     * @brief public instance method to obtain the value of this TileT object
     * @return the value of this TileT object
     */
    public int getValue()
    {
        return value;
    }

    /**
     * @brief public instance method to set the value for this TileT object
     * @param value the numerical value to be set for this TileT object
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * @brief public instance method to obtain the string representation of this TileT object
     * @return the string representation of this TileT object
     */
    public String toString()
    {
        return "" + value;
    }

    /**
     * @brief public instance method to determine the colour of this TileT object using its value
     */
    public void setColour()
    {
        if (this.getValue() == 2)
        {
            tileColour = COLOUR_WHEEL[0];
        }
        else if (this.getValue() == 4)
        {
            tileColour = COLOUR_WHEEL[1];
        }
        else if (this.getValue() == 8)
        {
            tileColour = COLOUR_WHEEL[2];
        }
        else if (this.getValue() == 16)
        {
            tileColour = COLOUR_WHEEL[3];
        }
        else if (this.getValue() == 32)
        {
            tileColour = COLOUR_WHEEL[4];
        }
        else if (this.getValue() == 64)
        {
            tileColour = COLOUR_WHEEL[5];
        }
        else if (this.getValue() == 128)
        {
            tileColour = COLOUR_WHEEL[6];
        }
        else if (this.getValue() == 256)
        {
            tileColour = COLOUR_WHEEL[7];
        }
        else if (this.getValue() == 512)
        {
            tileColour = COLOUR_WHEEL[8];
        }
        else if (this.getValue() == 1024)
        {
            tileColour = COLOUR_WHEEL[9];
        }
        else
        {
            tileColour = COLOUR_WHEEL[10];
        }
    }

    /**
     * @brief public instance method to obtain the colour of this object
     * @return the colour of this TileT object
     */
    public Color getColour()
    {
        this.setColour();
        return tileColour;
    }
}
