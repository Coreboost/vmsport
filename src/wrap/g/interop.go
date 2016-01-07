package interop

func increment(a int) int {
	return a+1
}

func increment_ref(a *int) {
	*a += 1
}
