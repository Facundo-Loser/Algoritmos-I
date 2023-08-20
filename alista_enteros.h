#define NMAX 100

typedef struct{
	int cant;
	int array[NMAX];
}arreglo;

//Acción que muestra un arreglo
void mostrar_arreglo(arreglo arr);

//Funció que dado un arreglo de enteros dice si el mismo está vacío o no
int es_vacio(arreglo arr);

//Acción que me dice si hay más positivos que negativos o viceversa en el arreglo 
void posNeg(arreglo arr);