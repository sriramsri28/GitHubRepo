Feature: Title of your feature
  I want to use this template for my feature file

  @name1
  Scenario: Title of your scenario
  * print "Test2 tag1"
  @tag2
  Scenario Outline: Title of your scenario outline
  * print "Test2 tag2"
  * print "I want to write a step with <name>"
  * print "I check for the <value> in step"
  * print "I verify the <status> in step"

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
