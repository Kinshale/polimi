/*
Si scriva un sottoprogramma rimuoviDuplicati che ricevuto in ingresso un array
di valori interi (e qualsiasi altro parametro ritenuto strettamente necessario),
trasmetta al chiamante un array contente i valori dell’array in ingresso privo
di duplicati. Prestare attenzione alle informazioni che il sottoprogramma ed il
chiamante si devono scambiare. Realizzare poi un programma che acquisiti al
massimo 50 valori interi strettamente positivi (l’acquisizione termina quando
l’utente inserisce un valore negativo o nullo) chiami il sottoprogramma e poi
visualizzi i valori privi di ripetizioni.
*/

#define MAXN 50

#include <stdio.h>

int removeDuplicates(int *array, int n, int *uniqueArray)
{
    int i, j, m;

    m = 0;

    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m && array[i] != uniqueArray[j]; j++) {}

        if (j == m) uniqueArray[m++] = array[i];
    }

    return m;
};

int main()
{
    int i, n, m, array[MAXLENGTH], uniqueArray[MAXLENGTH];

    n = -1;

    while (++n < MAXLENGTH)
    {
        scanf("%d", &array[n]);
        if (array[n] <= 0) break;
    }

    // After the loop, n is the length of array;

    m = removeDuplicates(array, n, uniqueArray); // returns the length of uniqueArray.

    printf("Unique Array is: \n");

    for (i = 0; i < m; i++)
        printf("%d  ", uniqueArray[i]);

    printf("\n");

    return 0;
}
