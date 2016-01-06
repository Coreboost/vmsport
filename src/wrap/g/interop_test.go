package interop

import "testing"

func TestIncrement(t *testing.T) {
  var b int
  b = increment(1)
  if b != 2 {
    t.Errorf("Expected increment to return 2, got %d", b)
  }
}

func TestIncrementReference(t *testing.T) {
  var b int
  b = 1
  increment_ref(&b)
  if b != 2 {
    t.Errorf("Expected incremented ref to be 2, got %d", b)
  }
}
