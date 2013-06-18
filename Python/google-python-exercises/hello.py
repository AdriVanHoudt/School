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

    ## sys import test
    sys.exit(0)


# defining function test
def repeat(s, exclaim, times):
    result = s * times

    if exclaim:
        result += '!!!'
    return result

# This is the standard boilerplate that calls the main() function.
if __name__ == '__main__':
    main()
