
// f2py -c add.f -m add
import unittest
import add

class TestFortranCalls(unittest.TestCase):

  def test_add(self):
      self.assertEqual(add.add(2, 3), 5)

if __name__ == '__main__':
    unittest.main()
