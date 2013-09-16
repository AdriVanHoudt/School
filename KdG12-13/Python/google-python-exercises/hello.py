#!/usr/bin/python -tt
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0

# Google's Python Class
# http://code.google.com/edu/languages/google-python-class/

"""A tiny Python program to check that Python is working.
Try running this program from the command line like this:
  python hello.py
  python hello.py Alice
That should print:
  Hello World -or- Hello Alice
Try changing the 'Hello' to 'Howdy' and run again.
Once you have that working, you're ready for class -- you can edit
and run Python code; now you just need to learn Python!
"""

import sys


# Define a main() function that prints a little greeting.
def main():
  ## Get the name from the command line, using 'World' as a fallback.
  if len(sys.argv) >= 2:
    name = sys.argv[1]
  else:
    name = 'World'
  print 'Howdy', name

  print repeat('Adri', True, 3)

  string_test()
  list_test()
  sort_test()

  ## sys import test
  sys.exit(0)


def sort_test():
  a = [5, 1, 4, 9, 6, 3, 7, 8]
  print sorted(a)
  print a

  strings = ['aaa', 'bb', 'CCC', 'zzz', 'XXXV', 'AaZ']
  print sorted(strings)
  print sorted(strings, reverse=True)
  print sorted(strings, key=str.lower)
  print sorted(strings, key=len)
  print sorted(strings, key=len, reverse=True)
  strs = ['xC', 'zb', 'ta', 'bd']
  print sorted(strs, key=keyFn)

  ## tuples
  tuple = (5, 10, 'Hello World')
  print len(tuple)
  print tuple[2]
  # gives error
  # tuple[2] = 'Howdy World'
  # works
  tuple = (5, 10, 'Howdy World')
  print tuple[2]

  ## comprehensions
  numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]
  print [n * n for n in numbers]
  print [s.upper() + '!!!' for s in strings]


def keyFn(s):
  return s[-1].lower()


def list_test():
  colors = ['red', 'green', 'blue']
  print colors[0]
  print colors[2]
  print len(colors)

  b = colors  # by reference, b points to same position in memory as colors!!
  b += ['yellow', 'orange']
  print colors[3]  # yellow

  numbers = [1, 4, 9, 16]
  Numbers = 0
  for num in numbers:
    Numbers += num
  print Numbers

  if 9 in numbers:
    print 'yay'

  for ch in b[3]:
    print ch

  for i in range(len(numbers)):
    print i

  list1 = ['test1', 'pom', 'Imbers velum in vasa!']
  list2 = ['Solem de alter gemna, gratia amicitia!', 'Naviss favere in burdigala!']
  list1.extend(list2)
  print list1


def string_test():
  ## string test
  s = 'hi'
  print s[1]
  print len(s)
  print s + ' there'

  pi = 3.14
  ## print 'the value of pi is ' + pi ## doesn't work
  print 'the value of pi is ' + str(pi)

  print 6 // 5  # double slashes because logic

  ## test for raw and multi strings
  raw = r'this\t\n and that'
  ## tab before second line is also added!
  multi = """It was the best of times.
    It was the worst of times."""

  print raw
  print multi

  print raw  # this\t\n and that

  ## Methods
  s = '555'
  if s.isdigit():
    print s
  s = 'some text just for test'
  print s.find('text')

  s = 'Hello'
  print s[:len(s)] + s[len(s):]

  ## %
  print "%d little pigs come out or I'll %s and %s and %s" % (3, 'huff', 'puff', 'blow down')

  ## if then else elif
  speed = 90
  mood = 'bad'

  if speed >= 80:
    print 'License and registration please.'
    if mood == 'terrible' or speed >= 100:
      print 'You have the right to remain silent.'
    elif mood == 'bad' or speed >= 90:
      print "I'm going to have to write a ticket."
      write_ticket()
    else:
      print "Let's try to keep it under 80 ok?"


# write_ticket for if then else statement
def write_ticket():
  print 'Ticket :O'


# defining function test
def repeat(s, exclaim, times):
  result = s * times

  if exclaim:
    result += '!!!'
  return result

# This is the standard boilerplate that calls the main() function.
if __name__ == '__main__':
  main()
