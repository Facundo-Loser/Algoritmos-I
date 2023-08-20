#include <stdio.h>
#include "alista_enteros.h"


void mostrar_arreglo(arreglo arr){
    printf("Arreglo: ");
    printf("[");

	for(int i = 0; i < arr.cant; i++){
		printf("%d,", arr.array[i]);
	}

	printf("]");
	printf("\n");
}


int es_vacio(arreglo arr){
	return arr.cant == 0;
}

void posNeg(arreglo arr){
	int i, pos, neg;

	pos = 0;
	neg = 0;

	for(i = 0; i < arr.cant; i++){
		if(arr.array[i] >= 0){
			pos++;
		}else{
			neg++;
		}
	}

	if(pos > neg){
		printf("Hay más números positivos que negativos\n");
		printf("Positivos: %d\n", pos);
		printf("Negativos: %d\n", neg);
	}else{
		printf("Hay más números negativos que positivos\n");
		printf("Positivos: %d\n", pos);
		printf("Negativos: %d\n", neg);
	}
}
