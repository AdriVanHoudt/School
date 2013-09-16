using System;
using WindowsFormsApplication1;

namespace deelC.GameLogic
{
  class Throw
  {
    private int _totalValue;
    private readonly Random _randGenerator = new Random((int)DateTime.Now.Ticks);

    public Throw()
    {
      throwDices();
    }

    private int throwDices()
    {
      Dice dice1 = new Dice(_randGenerator);
      _totalValue += dice1.getValue();
      Dice dice2 = new Dice(_randGenerator);
      _totalValue += dice2.getValue();
      Dice dice3 = new Dice(_randGenerator);
      _totalValue += dice3.getValue(); 
      switch (_totalValue)
      {
        case 300:
          return 9;
        case 69:
          return 3;
        default:
          if((dice1.getValue() == dice2.getValue()) && (dice2.getValue() == dice3.getValue()))
          {
            return 2;
          }
            return 1;
      }
        //TODO: aply dice values to UX
    }

    public int getTotalValue()
    {
      return _totalValue;
    }

    public int throwNow()
    {
      return throwDices();
    }
  }
}
