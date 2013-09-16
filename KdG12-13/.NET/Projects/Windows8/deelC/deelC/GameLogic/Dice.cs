using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApplication1
{
  class Dice
  {
    private int value;
    private int translatedValue;


    public Dice(Random randGenerator)
    {
      rollDice(randGenerator);
    }

    private void rollDice(Random randGenerator)
    {
      value = randGenerator.Next(5) + 1; 
      switch (value)
      {
        case 1: 
          translatedValue = 100;
          break;
        case 6:
          translatedValue = 60;
          break;
        default: translatedValue = value;
          break;
      }
    }

    public int getValue()
    {
      return translatedValue;
    }


  }
}
