using System;
using System.Collections.Generic;
using System.Linq;
using Windows.UI.Xaml;
using WindowsFormsApplication1;
using deelC;

namespace deelC.GameLogic
{
  class InitGame
  {
    private readonly List<Player> _players;
    private int _maxAmountOfTurns;
    private int _maxScore;
    private int _maxValue;
    private int _currentPlayerNumber;
    private int _winningPlayerNumber;
    private Boolean _stillPlaying = true;
    private readonly MainPage _mainPage = new MainPage();

    public InitGame(List<string>playerNames){
        _players = playerNames.Select(name => new Player(name)).ToList();
      _currentPlayerNumber = 0;
      while (_stillPlaying)
      {
          playGame();
      }
    }

    private void playGame()
    {
        _maxAmountOfTurns = 0;
        _maxValue = 0;
        _maxScore = 0;

        int previousPlayer = _winningPlayerNumber;

        firstPlayerTurn();

        for (int i = 0; i < _players.Count; i++)
        {
            _mainPage.output1.Text = "=================\n" + _winningPlayerNumber + "\n=================";
            if (i != previousPlayer)
            {
                _currentPlayerNumber = i;
                otherPlayer();
            }
        }
        Console.ReadLine();
        _players[_winningPlayerNumber].deductLives(_maxScore);


        foreach (Player player in _players)
        {
            Console.WriteLine(player.getName() + ": " + player.getLives().ToString());
            if (player.getLives() <= 0)
            {

                _stillPlaying = false;
            }
            Console.ReadLine();
        }
        _currentPlayerNumber = _winningPlayerNumber;
    }

    private void firstPlayerTurn()
    {
      _mainPage.output1.Text=_players[_currentPlayerNumber].getName();
      Boolean throwing = true;
      int counter= 0;
      while (throwing && (counter < 2))
      {
        Throw myThrow = new Throw();
        int score = myThrow.throwNow();
        int value = myThrow.getTotalValue();
        _mainPage.output2.Text=_maxScore + "   " + score;
        if ((score >= _maxScore))
        {
          if ((value > _maxValue))
          {
            _winningPlayerNumber = _currentPlayerNumber;
            _maxScore = score;
            _maxValue = value;
          }
          
        }
        _mainPage.output1.Text = "Wanna throw again?" + _players[_currentPlayerNumber].getName();
        _mainPage.btnThrowAgainY.Visibility = Visibility.Visible;
        _mainPage.btnThrowAgainN.Visibility = Visibility.Visible;
          if (Console.ReadLine().Equals("n"))
        {
          throwing = false;
        }
        else
        {
          counter++;
        }
      }      
      _maxAmountOfTurns = counter;
      _mainPage.output1.Text=""+_maxAmountOfTurns;
    }

    private void otherPlayer()
    {    
      int counter= 0;
      while (counter <= _maxAmountOfTurns)
      {
          _mainPage.output1.Text = _players[_currentPlayerNumber].getName() + "   " + _currentPlayerNumber;
        Throw myThrow = new Throw();
        int score = myThrow.getScore();
        int value = myThrow.getTotalValue();
        _mainPage.output1.Text=_maxScore + "   " + score;
        if ((score >= _maxScore))
        {
          if ((value > _maxValue))
          {
            _winningPlayerNumber = _currentPlayerNumber;
            _maxScore = score;
            _maxValue = value;
          }

        }
        counter++;
      }
    }
  }
}