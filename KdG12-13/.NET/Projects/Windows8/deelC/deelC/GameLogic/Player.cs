using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApplication1
{
  class Player
  {
    private int nrLives;
    private string name;

    public Player(string name)
    {
      nrLives = 9;
      this.name = name;
    }

    public void deductLives(int livesLost)
    {
      nrLives -= livesLost;
    }

    public int getLives()
    {
      return nrLives;
    }

    public string getName()
    {
      return name;
    }
  }
}
