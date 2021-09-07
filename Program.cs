using System;

namespace assignment1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome,this application will help you find the distance between 2 points");
            Console.Write(" and also calculate the angle between those points");
            Console.WriteLine();
            Console.Write("Enter first x value: ");
            float x1 = float.Parse(Console.ReadLine());
            Console.WriteLine();
            Console.Write("Enter first y value: ");
            float y1 = float.Parse(Console.ReadLine());
            Console.WriteLine();
            Console.Write("Enter second x value: ");
            float x2 = float.Parse(Console.ReadLine());
            Console.WriteLine();
            Console.Write("Enter second y value: ");
            float y2 = float.Parse(Console.ReadLine());
            double deltax = x1 - x2;
            double deltay = y1 - y2;
            double hypotenuse = Math.Sqrt(Math.Pow(deltax, 2) + Math.Pow(deltay, 2));
            double angle = Math.Atan2(-deltax,-deltay)/Math.PI*180;
            Console.WriteLine();
            Console.WriteLine("The distance between points (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") is " + hypotenuse);
            Console.WriteLine("The angle between the two points is " + angle);
        }
    }
}
