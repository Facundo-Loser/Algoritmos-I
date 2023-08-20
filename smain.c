#include <stdio.h>
#include "alista_enteros.h"

//arreglo arr = {1,2,3,4,5,6,7,8,9,10};
arreglo arr = {1,2,-3,-4,-5,-6,7,8,9,10};

int main(){
	arr.cant = 10;
	mostrar_arreglo(arr);
    posNeg(arr);
	return 0;
}