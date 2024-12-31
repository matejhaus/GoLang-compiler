package main

import "fmt"

func main() {
	var matrix [5][5]int = [5][5]int{
		{1, 8, 4, 2, 4},
		{3, 2, 0, 6, 8},
		{2, 7, 1, 7, 9},
		{9, 2, 4, 6, 8},
		{6, 3, 5, 8, 5},
	}
	var i int = 0
	for i < 5 {
		var j int = 0
		for j < 5 {
			fmt.Print(matrix[i][j], " ")
			j = j + 1
		}
		fmt.Println()
		i = i + 1
	}
}
