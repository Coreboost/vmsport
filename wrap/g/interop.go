package main

import "fmt"
//import "strconv"

// #cgo LDFLAGS: -L../lib -lmyc
// #include "../clib/libmyc.h"
// int c_one, c_two;
import "C"

func test_suite()(func(string, func()(string)), func()) {
		var tests map[string] func()(string) = make(map[string] func()(string))
		add_test := func(name string, testFunction func()(string)) {
			tests[name] = testFunction
		}
		run := func() {
			var failures map[string]string = make(map[string]string)
			passed := 0
			failed := 0
			for test := range tests {
				message := tests[test]();
				fmt.Printf(".")
				if message=="" {
					passed += 1
				} else {
					failed += 1
					failures[test] = message
				}
			}
			fmt.Printf("\n%d tests executed, %d failed.\n", passed+failed, failed)
			for failed := range failures {
				fmt.Printf("*** %s :: %s\n", failed, failures[failed])
			}
		}
		return add_test, run
}

func main() {
	add_test, run_test := test_suite()
	add_test("Test add in C",
		func()(string) {
			r := int(C.add(1, 2))
			if r != 3 {
				return fmt.Sprintf("Expected 3, got %d.", r)
			}
			return ""
		})

	add_test("Test add references in C",
		func()(string) {
			C.c_one = C.int(1)
			C.c_two = C.int(2)
			r := int(C.add_ref(&C.c_one, &C.c_two))
			if r != 3 {
				return fmt.Sprintf("Expected 3, got %d.", r)
			}
			return ""
		})

	run_test()
/*
	test_suite.add_test("Test name", testfunction);
	func run
	var rr int
  rr = int(C.add(1, 2))
	fmt.Printf("Result: " + strconv.Itoa(rr) + "\n")
*/
}
