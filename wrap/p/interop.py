import unittest
import F

class TestFortranCalls(unittest.TestCase):

  def test_add(self):
      self.assertEqual(F.add(2, 3), 5)

  def test_addvector(self):
      a = [1, 2]
      b = [3, 4]
      c = F.addvector(a, b)
      self.assertEqual(c[0], 4)
      self.assertEqual(c[1], 6)

  def test_concat(self):
      self.assertEqual(F.concat(b"Skala", b"Banan").rstrip(), "SkalaBanan")

if __name__ == '__main__':
    unittest.main()
