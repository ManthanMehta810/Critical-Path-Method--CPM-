import java.util.*;
import java.io.*;
public class Cpm
{
	public static void main(String args[])
	{
		int no,c=0,a,z=1,r=0,y,t=0,q=0,x=0,var=0,var1=0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter No of Event");
		no=s.nextInt();
		System.out.println("Enter no of activity");
		a=s.nextInt();
		int E[][] = new int[100][100];
		int s1[]=new int[100];
		int e1[]=new int[100];		
		int d[]=new int[100];
		int fp[]=new int[100];
		int est[]=new int[100];
		int lft[]=new int[100];
		int bp[]=new int[100];
		int eft[]=new int[100];
		int lst[]=new int[100];	
		int tf[]=new int[100];	
		int ff[]=new int[100];
		int ind[]=new int[100];
		int int1[]=new int[100];		
		for(int i=1;i<=no;i++)
		{
			for(int j=1;j<=no;j++)
				E[i][j]=-1;
		}
		L1:while(true && a!=c)
		{	
			System.out.println("1.Add Activity\n2.Exit");
			int ch=s.nextInt();
			switch(ch)
			{
				case 1:
				    if(a!=c)
					{
						System.out.println("Enter Starting Point And Ending Point");
						int sp=s.nextInt();
						int ep=s.nextInt();
						System.out.println("Enter Duration");
						int	d1=s.nextInt();		
						c++;
						for(int i=1;i<=no;i++)
						{
							if(sp==ep)
							{
								E[sp][ep]=-1;
								E[ep][sp]=-1;
							}
							else
							{
								E[sp][ep]=d1;
								E[ep][sp]=d1;
							}
						}
					}
					break;
				case 2:
					break L1;
				default:
					System.out.println("Invaild Choice");
			}
		}
		for(int i=1;i<=no;i++)
		{
			for(int j=1;j<=no;j++)
			{
				if(E[i][j]!=-1)
				{
					if(i<j)
					{
						x++;
						d[x]=E[i][j];
						s1[x]=i;
						e1[x]=j;
					}
				}
			}
		}
		fp[z]=0;
		z++;
		while(z<=no)
		{
			for(int i=1;i<=no;i++)
			{
				if(i<z)
				{
					if(E[i][z]!=-1)
					{
						var=fp[z];
						fp[z]=fp[i]+E[i][z];
						r++;
						if(r>1 && (fp[z]<var))
						{
							fp[z]=var;
						}
					}
				}	
			}
			z++;
			r=0;
		}
		y=no-1;
		bp[no]=fp[no];
		while(y>=1)
		{
			for(int i=no;i>=1;i--)
			{
				if(i>y)
				{
					if(E[i][y]!=-1)
					{
						var1=bp[y];
						bp[y]=bp[i]-E[i][y];
						t++;
						if(t>1 && (bp[y]>var1))
						{
							bp[y]=var1;
						}
					}
				}	
			}
			t=0;
			y--;
		}	
		for(int i=1;i<=no;i++)
		{
			for(int j=1;j<=no;j++)
			{
				if(E[i][j]!=-1)
				{
					if(i<j)
					{
						q++;
						est[q]=fp[i];
						lft[q]=bp[j];
					}
				}
			}
		}
		for(int i=1;i<=a;i++)
		{
			eft[i]=est[i]+d[i];
			lst[i]=lft[i]-d[i];
			tf[i]=lft[i]-est[i]-d[i];
			ff[i]=eft[i]-est[i]-d[i];
			ind[i]=eft[i]-lst[i]-d[i];
			int1[i]=tf[i]-ff[i];
		}
		for(int i=1;i<=no;i++)
		{
			for(int j=1;j<=no;j++)
			{
				System.out.print(+E[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
		System.out.println("no of edges: "+c);
		System.out.println("d[x]: ");
		for(int i=1;i<=a;i++)
		{
			System.out.println(+d[i]);
		}
		System.out.println("fp[z]: ");	
		for(int i=1;i<=no;i++)
		{
			System.out.println(+fp[i]);
		}
		System.out.println("bp[y]: ");	
		for(int i=1;i<=no;i++)
		{
			System.out.println(+bp[i]);
		}
		System.out.println("est[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+est[i]);
		}
		System.out.println("lft[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+lft[i]);
		}	
		System.out.println("eft[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+eft[i]);
		}	
		System.out.println("lst[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+lst[i]);
		}
		System.out.println("tf[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+tf[i]);
		}
		System.out.println("ff[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+ff[i]);
		}
		System.out.println("ind[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+ind[i]);
		}
		System.out.println("int1[q]: ");	
		for(int i=1;i<=a;i++)
		{
			System.out.println(+int1[i]);
		}
		System.out.println("Project Duration:");
		System.out.print(+fp[no]);
		System.out.print(" days required to complete the project.\n");
		System.out.println("Critical Activity:");
		for(int i=1;i<=a;i++)
		{
			if(eft[i]==lft[i] && tf[i]==0)
			{
				System.out.print(+s1[i]);
				System.out.print("-");
				System.out.print(+e1[i]);
				if(i!=a)
				{
					System.out.print(",");
				}
			}
		}
		System.out.print("\n");
		System.out.println("Critical Path:");	
		for(int i=1;i<=a;i++)
		{
			if(eft[i]==lft[i] && tf[i]==0)
			{
				System.out.print(+s1[i]);
				System.out.print("-");
				if(s1[i]==e1[i])
				{
					System.out.print(+e1[i]);
				}
			}
		}
		System.out.print(+e1[a]);
		System.out.print("\n");
	}
}