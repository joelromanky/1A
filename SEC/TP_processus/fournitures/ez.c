#include <stdio.h>
#include <unistd.h>
#include <stdlib.h> /* exit */

int main(int argc, char *argv[]) {
    int tempsPere, tempsFils;
    int v=5; /* utile pour la section 2.3 */
    pid_t pidFils;

    tempsPere=60;
    tempsFils=120;
    pidFils=fork();
    /* bonne pratique : tester systématiquement le retour des appels système */
    if (pidFils == -1) {
        printf("Erreur fork\n");
        exit(1);
        /* par convention, renvoyer une valeur > 0 en cas d'erreur,
         * différente pour chaque cause d'erreur
         */
    }
    if (pidFils == 0) {		/* fils */
		v = 100;
        printf("processus %d (fils), de père %d, valeur de v %d\n", getpid(), getppid(),v);
        sleep(tempsFils);
        printf("fin du fils\n");
        printf("valeur de v %d\n",v);
        exit(EXIT_SUCCESS); /* 	bonne pratique : 
        						terminer les processus par un exit explicite */
    }
    else {		/* père */
		v = 10;
        printf("processus %d (père), de père %d, valeur de v %d\n", getpid(), getppid(), v);
        sleep(tempsPere);
        printf("fin du père\n");
        printf("valeur de v %d\n",v);        
    }
    return EXIT_SUCCESS; /* -> exit(EXIT_SUCCESS); pour le père */
}
