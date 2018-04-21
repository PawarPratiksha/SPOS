#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
//#include<sys/type.h>

void parent()
{
	printf("\n\tThis is parent task");
	printf("\n\tChild dies...hence parent executing");
}
void main()
{
	pid_t pid,pid1;
	int status;

	printf("\n\tParent executing");
	pid=fork();
	
	if(pid==0)
	{
		printf("\n\tChild Created");
		printf("%d ",pid);
		sleep(10);
		printf("\n\tChild after sleep");
		execlp("/bin/ps","ps",NULL);
		exit(0);
	}
	else
	{
		printf("\n\tParent again executing");
		printf("%d ",pid);
		pid1=wait(&status);
		printf("\n%d ",pid1);
		parent();
		printf("\n\tParent after child exit");
		printf("\n\tParent terminating");
		exit(0);
		
	}
}

/*

steps: 
1. gedit madhe program typing
2. kkw dir madhe save with .c extension
3.application->accessories->terminal
4. vi system_call.c (vi is a editor thru wich we can edit or see the prog)
5. shift :q (enter)
6. cc system_call.c (to compile file)
7. ./a.out (to see the output)

./ indicates the current dir
../ parent of current directory
a.out madhe current running prog cha output.
cd to change the directory.*/
