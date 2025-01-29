import java.util.*;

public class Sorting {

      static class Frame {
            String content;
            int fnum;

            Frame(int n, String s) {
                  this.fnum = n;
                  this.content = s;
            }
      }

      public static void sorting(int n, Frame[] F) {
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n - i - 1; j++) {
                        if (F[j].fnum > F[j + 1].fnum) {
                              Frame temp = F[j];
                              F[j] = F[j + 1];
                              F[j + 1] = temp;
                        }
                  }
            }
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the number of frames : ");
            int n = sc.nextInt();

            Frame[] F = new Frame[n];

            System.out.println("Enter the frame details : ");
            for (int i = 0; i < n; i++) {
                  System.out.println("\n Enter the frame number");
                  int a = sc.nextInt();

                  sc.nextLine();

                  System.out.println("Enter frame content");
                  String b = sc.nextLine();

                  F[i] = new Frame(a, b);
            }

            // shuffle frames
            List<Frame> frameList = new ArrayList<>(Arrays.asList(F));
            Collections.shuffle(frameList);
            F = frameList.toArray(new Frame[0]);

            System.out.println("\nBefore sorting (shuffled frames)");
            for (Frame frame : F) {
                  System.out.println(frame.content + " ");
            }
            sorting(n, F);

            // Display sorted frame content
            System.out.println("\n\nAfter Sorting the frames:");
            for (Frame frame : F) {
                  System.out.print(frame.content + " ");
            }
            System.out.println();

            sc.close();
      }
}