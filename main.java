import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class main {
    public static void main(String[] args) {
        TwoFour tf = new TwoFour();
        Heap hp = new Heap(10000000);
        AVLTree av = new AVLTree();
        Node node=new Node();
        List<phoneBook> n = readphoneBookFroCSV("C:\\Users\\User\\Desktop\\DOC-20220430-WA0005 (2).csv");
        n.remove(0);
        Scanner s = new Scanner(System.in);
        String conct[] = new String[n.size()];
//        for (int i = 0; i < n.size(); i++) {
//            conct[i]=n.get(i).getName();
//        }
//        for (int i = 0 ; i < n.size(); i++){
//            hp.insert(n.get(i));
//        }
//        System.out.println(hp.heightOfTree());
   //     hp.print();
//        hp.delete("Reese Compton");
//        hp.print();
//        hp.search("Reese Compton");
//        for (int i = 0; i < n.size(); i++) {
//            tf.insertTWOFOUR(n.get(i).getName(), n.get(i).getEmail(), n.get(i).getPhoneNumb(), n.get(i).getAddress());
//        }
//        tf.find("Amy Briggs");
//        tf.deleteTWOFOUR("Amy Briggs");
//        tf.insertTWOFOUR("yassien","swjkdqegfyewbhf3q","0102832475","dfergtwh5ytgfewgrt");
//        tf.deleteTWOFOUR("Reese Compton");
//        tf.find("yassien");
//        tf.find("Amy Briggs");
//        tf.find("Reese Compton");
//        tf.displayTree(0);
//        System.out.println(tf.getheight());
//        tf.displayTree(3);
//        for (int i = 0; i < n.size(); i++) {
//            av.insAVL(n.get(i).getName(), n.get(i).getEmail(), n.get(i).getPhoneNumb(), n.get(i).getAddress());
//        }
//        for (int i = 0; i < conct.length; i++) {
//            tf.insertTWOFOUR(conct[i]);
//        }
   //     tf.displayTree(0);
//         for (int i = 0; i < conct.length; i++) {
//         av.insAVL(n.get(i).getName(), n.get(i).getEmail(), n.get(i).getPhoneNumb(), n.get(i).getAddress());
//         }
//        av.SearchAVl("Amy Briggs");
//       av.deleteAvl("Reese Compton");
//        av.deleteAvl("Amy Briggs");
//        av.SearchAVl("Amy Briggs");
  //      av.SearchAVl("Reese Compton");
//        av.inorderAVL();
//        System.out.println(av.getheight());
//        av.print();
//        System.out.println(av.getnuberNode());
         System.out.println("Choose binary search type: \n 1-AVL \n 2-2-4 tree \n 3-heap \n 4- exit");
        int x = s.nextInt();
        boolean type1 = true;
        if (x == 1) {
            for (int i = 0; i < n.size(); i++) {
                av.insAVL(n.get(i).getName(), n.get(i).getEmail(), n.get(i).getPhoneNumb(), n.get(i).getAddress());
            }
            while (type1 == true) {
                System.out.println("what do you want to do? \n1-insertion\n2-deletion\n3-search\n4-count number of nodes\n5-get height\n6-print inorder\n7-print the tree\n8-exit");
                int y = s.nextInt();
                if (y == 1) {
                    System.out.println("name?");
                    s.nextLine();
                    String name = s.nextLine();
                    System.out.println("phone?");
                    String number = s.next();
                    System.out.println("email?");
                    String email = s.next();
                    System.out.println("address");
                    String address = s.next();
                    av.insAVL(name, email, number, address);
                } else if (y == 2) {
                    System.out.println("name you want to delete?");
                    s.nextLine();
                    String namedele=s.nextLine();
                    av.deleteAvl(namedele);
                } else if (y == 3) {
                    System.out.println("name?");
                    s.nextLine();
                    String namesearch = s.nextLine();
                    av.SearchAVl(namesearch);
                } else if (y == 4) {
                    System.out.println(av.getnuberNode());
                } else if (y == 5) {
                    System.out.println(av.getheight());
                } else if (y == 6) {
                    av.inorderAVL();
                } else if (y == 7) {
                    av.print();
                } else if (y == 8) {
                    type1 = false;
                } else {
                    System.out.println("invalid");
                }
            }
        } else if (x == 2) {
            for (int i = 0; i < n.size(); i++) {
                tf.insertTWOFOUR(n.get(i).getName(), n.get(i).getEmail(), n.get(i).getPhoneNumb(), n.get(i).getAddress());
            }
            while (type1 == true) {
                System.out.println("what do you want to do? \n1-insertion\n2-deletion\n3-search\n4-count number of nodes\n5-get height\n6-print inorder\n7-print the tree\n8-exit");
                int y = s.nextInt();
                if (y == 1) {
                    System.out.println("name?");
                    s.nextLine();
                    String name = s.nextLine();
                    System.out.println("phone?");
                    String number = s.next();
                    System.out.println("email?");
                    String email = s.next();
                    System.out.println("address");
                    String address = s.next();
                    tf.insertTWOFOUR(name,email,number,address);
                } else if (y == 2) {
                    System.out.println("name you want to delete?");
                    s.nextLine();
                    String namesear = s.nextLine();
                    tf.deleteTWOFOUR(namesear);
                } else if (y == 3) {
                    System.out.println("name?");
                    s.nextLine();
                    String namedel = s.nextLine();
                    av.SearchAVl(namedel);
                } else if (y == 4) {
                    System.out.println(tf.getnumberofnodes());
                } else if (y == 5) {
                    System.out.println(tf.getheight());
                } else if (y == 6) {
                    tf.displayTree(0);
                } else if (y == 7) {
                    tf.displayTree(3);
                } else if (y == 8) {
                    type1 = false;
                } else {
                    System.out.println("invalid");
                }
            }
        } else if (x == 3) {
            while (type1 == true) {

            }
        } else if (x == 4) {
            while (type1 == true) {
                type1 = false;
                break;
            }
        } else {
            System.out.println("invalid");
        }
    }

    public static List<phoneBook> readphoneBookFroCSV(String filePath) {
        List phoneBooks = new ArrayList<phoneBook>();
        // Set<phoneBook> phoneBooks = new TreeSet<phoneBook>();
        Path path = Paths.get(filePath);
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\User\\Desktop\\DOC-20220430-WA0005 (2).csv"));
            int iteration = 0;
            String line = br.readLine();
            while (line != null) {
                String[] att = line.split(",");
                phoneBook p = createPhoneBook(att);
                phoneBooks.add(p);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneBooks;
    }

    public static phoneBook createPhoneBook(String[] meta) {
        String name = meta[0];
        String phone = meta[1];
        String email = meta[2];
        String address = meta[3];
        return new phoneBook(name, phone, email, address);
    }

    public static void testing() {
        String First = "b";
        String Fi = "azzzzz";
        String[] arr = { "ahmed galal", "ahmed ahmed" };
        System.out.println(Fi.compareTo(First));
        // int compare = First.compareTo(Fi);
        // Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
    }
}