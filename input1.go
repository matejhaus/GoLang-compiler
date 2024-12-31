package main

import "fmt"

func main() {
	var a int = 5
	var b int = 8

	var soucet int = a + b

	if soucet%2 == 0 {
		fmt.Println("Součet je sudý")
	} else {
		fmt.Println("Součet je lichý")
	}

	fmt.Println(soucet)
}
