#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define N 10

int a[N][N], s[N],n;

// compute the sum of each row

void* f(void* p) {
   int k = *((int*) p);
   int i;
   for (i = 0; i < n; i++) {
      s[k] += a[k][i];
   }
   return NULL;
}

int main() {
    int i, j, *p, rc;
    int sum = 0;
    pthread_t th[N];

    // matrix creation
    printf("Input N (<=10): ");
    scanf("%d", &n);

    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            printf("a[%d][%d] = ", i, j);
            scanf("%d", &a[i][j]);
        }
    }

    printf("\nThe matrix is: \n");
    for(i=0; i < n; i++) {
        for(j=0; j < n; j++)
            printf("%d ", a[i][j]);
    printf("\n");
    }

    // thread creation
    for (i=0; i < n; i++) {
        p = malloc(sizeof(int));
        *p = i;
        rc = pthread_create(&th[i], NULL, f, p);
        if (rc != 0) {
            printf("Thread creation failed");
            exit(-1);
        }
    }

    for (i=0; i < n; i++) {
        pthread_join(th[i], NULL);
    }
    // compute the final sum
    for (i=0; i < n; i++) {
        sum += s[i];
    }
    printf("The sum is = %d\n", sum);

    return 0;
    }

