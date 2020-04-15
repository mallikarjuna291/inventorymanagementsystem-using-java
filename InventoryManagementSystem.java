import java.util.*;
import java.io.*;
interface inventory
{
    public void AvailableInventory();
}
class GroceryInventory implements inventory
{
    public void AvailableInventory()
    {
        int i;
        String[] Inventory = {"Pulses","Vegetable","Fruits","Daily Essentials","MilkProducts"};
        int n =Inventory.length;
        for(i=0;i<n;i++)
        {
            System.out.println(Inventory[i]);
        }
    }
}
class MedicineInventory implements inventory
{
    public void AvailableInventory()
    {
        int i;
        String[] Inventory = {"Paracetamol","Oflacxin200","levocitrizen","Motelukasi","Desloratadine"};
        int n =Inventory.length;
        for(i=0;i<n;i++)
        {
            System.out.println(Inventory[i]);
        }
    }
}
abstract class ShowInventory
{
    abstract void getGroceryDetails();
    abstract void getMedicineDetails();
}
class MyInventory extends ShowInventory
{

    void getGroceryDetails()
    {
        try {
            FileWriter fw = new FileWriter("Grocery.txt");
            PrintWriter pw = new PrintWriter(fw);
            Random generate = new Random();
            String[] Inventory = {"Pulses","Vegetable","Fruits","Daily Essentials","MilkProducts"};
            int n =Inventory.length;
//            String Inventoryoption=Inventory[generate.nextInt(n)];
            pw.println(Inventory[generate.nextInt(n)]+" Available");
            pw.println(Inventory[generate.nextInt(n)]+" Available");
            pw.println(Inventory[generate.nextInt(n)]+" Available");
            pw.println(Inventory[generate.nextInt(n)]+" NotAvailable");
            pw.println(Inventory[generate.nextInt(n)]+" NotAvailable");
            pw.close();
            FileReader fr = new FileReader("Grocery.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null)
            {
                System.out.println(str);
            }
            br.close();

        }
        catch (IOException e)
        {
            System.out.println("Invalid");
        }

    }
    void getMedicineDetails()
    {
        try {
            FileWriter fw = new FileWriter("Medicine.txt");
            PrintWriter pw = new PrintWriter(fw);
            Random generate = new Random();
            String[] Inventory = {"Paracetamol","Oflacxin200","levocitrizen","Motelukasi","Desloratadine"};
            int n =Inventory.length;
//            String Inventoryoption=Inventory[generate.nextInt(n)];
            pw.println(Inventory[generate.nextInt(n)]+" Available");
            pw.println(Inventory[generate.nextInt(n)]+" Available");
            pw.println(Inventory[generate.nextInt(n)]+" Available");
            pw.println(Inventory[generate.nextInt(n)]+" NotAvailable");
            pw.println(Inventory[generate.nextInt(n)]+" NotAvailable");
            pw.close();
            FileReader fr = new FileReader("Medicine.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null)
            {
                System.out.println(str);
            }
            br.close();

        }
        catch (IOException e)
        {
            System.out.println("Invalid");
        }


    }
}
public class InventoryManagementSystem
{
    public static void main(String[] args) {
        Scanner Sc =new Scanner(System.in);
        MedicineInventory MI =new MedicineInventory();
        GroceryInventory GI =new GroceryInventory();
        ShowInventory Si = new MyInventory();

        System.out.println("\t\t\t\t\t\tInventory Management System");
        System.out.println("Available Inventory");
        System.out.println(" ");
        System.out.println("1.Grocery Inventory");
        System.out.println("2.Medicine Inventory");
        System.out.println(" ");
        System.out.println("Enter 1 For Grocery Inventory\t\t\tEnter 2 For Medicine Inventory");
        System.out.println("Enter your Option");
        String option = Sc.nextLine();
        if (option.equals("1"))
        {
            GI.AvailableInventory();
            System.out.println("Do You Want to See Available Quantity[y/n]");
            String choice = Sc.nextLine();
            if (choice.equals("y"))
            {
                Si.getGroceryDetails();
            }
            else
            {
                System.exit(0);
            }

        }
        else if (option.equals("2"))
        {
            MI.AvailableInventory();
            System.out.println("Do You Want to See Available Quantity[y/n]");
            String choice = Sc.nextLine();
            if (choice.equals("y"))
            {
                Si.getMedicineDetails();
            }
            else
            {
                System.exit(0);
            }

        }
        else
        {
            System.exit(0);
        }
    }

}
