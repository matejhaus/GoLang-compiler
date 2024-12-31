package main

import "fmt"

func suma(pole [10]float64) float64 {
	var i int = 0
	var suma float64 = 0.0

	for i < 10 {
		suma = suma + pole[i]
		i = i + 1
	}
	return suma
}

func main() {
	var pole [10]float64 = [10]float64{8.3, 1.8, 5.5, 6.1, 9.9, 20.3, 5.42, 15.9, 10.0, 4.9}

	var i int = 0
	fmt.Print("Pole: ")

	for i < 10 {
		fmt.Print(pole[i], " ")
		i = i + 1
	}

	fmt.Println()

	var sumaResult float64 = suma(pole)

	fmt.Println("Suma:", sumaResult)
	fmt.Println("Průměr:", sumaResult/10)
}
