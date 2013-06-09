using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.OperatorOverloading
{
    class OperatorOverloadingProgram
    {
        static void Main(string[] args)
        {
            #region value-types
            Console.WriteLine("******************************** VALUE-TYPE ********************************");

            int i1 = 1;
            int i2 = i1;
            int i3 = 1;

            Console.WriteLine("===== INT =====");
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "Object.ReferenceEquals(i1, i2)", Object.ReferenceEquals(i1, i2));
            Console.WriteLine("{0,-40}{1}", "Object.ReferenceEquals(i1, i3)", Object.ReferenceEquals(i1, i3));
            Console.WriteLine("{0,-40}{1}", "Object.ReferenceEquals(i2, i3)", Object.ReferenceEquals(i2, i3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "Object.Equals(i1, i2)", Object.Equals(i1, i2));
            Console.WriteLine("{0,-40}{1}", "Object.Equals(i1, i3)", Object.Equals(i1, i3));
            Console.WriteLine("{0,-40}{1}", "Object.Equals(i2, i3)", Object.Equals(i2, i3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "i1.Equals(i2)", i1.Equals(i2));
            Console.WriteLine("{0,-40}{1}", "i1.Equals(i3)", i1.Equals(i3));
            Console.WriteLine("{0,-40}{1}", "i2.Equals(i3)", i2.Equals(i3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "i1 == i2", i1 == i2);
            Console.WriteLine("{0,-40}{1}", "i1 == i3", i1 == i3);
            Console.WriteLine("{0,-40}{1}", "i2 == i3", i2 == i3);
            Console.WriteLine();

            MyStruct ms1_1 = new MyStruct(10);
            MyStruct ms1_2 = ms1_1;
            MyStruct ms1_3 = new MyStruct(10);

            MyStructOperatorOverloading ms2_1 = new MyStructOperatorOverloading(20);
            MyStructOperatorOverloading ms2_2 = ms2_1;
            MyStructOperatorOverloading ms2_3 = new MyStructOperatorOverloading(20);

            Console.WriteLine();
            Console.WriteLine("===== MYSTRUCT OPERATOR OVERLOADING =====");
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1,-10}{2,-10}", "", "MyStruct", "Equals&Operator");
            Console.WriteLine("{0,-40}{1,-10}{2,-10}", "Object.ReferenceEquals(ms_1, ms_2)", Object.ReferenceEquals(ms1_1, ms1_2), Object.ReferenceEquals(ms2_1, ms2_2));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}", "Object.ReferenceEquals(ms_1, ms_3)", Object.ReferenceEquals(ms1_1, ms1_3), Object.ReferenceEquals(ms2_1, ms2_3));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}", "Object.ReferenceEquals(ms_2, ms_3)", Object.ReferenceEquals(ms1_2, ms1_3), Object.ReferenceEquals(ms2_2, ms2_3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1,-10}{2,-10}", "Object.Equals(ms_1, ms_2)", Object.Equals(ms1_1, ms1_2), Object.Equals(ms2_1, ms2_2));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}", "Object.Equals(ms_1, ms_3)", Object.Equals(ms1_1, ms1_3), Object.Equals(ms2_1, ms2_3));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}", "Object.Equals(ms_2, ms_3)", Object.Equals(ms1_2, ms1_3), Object.Equals(ms2_2, ms2_3));
            Console.WriteLine();
            //Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_1.Equals(ms_2)", ms1_1.Equals(ms1_2), ms2_1.Equals(ms2_2));
            //Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_1.Equals(ms_3)", ms1_1.Equals(ms1_3), ms2_1.Equals(ms2_3));
            //Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_2.Equals(ms_3)", ms1_2.Equals(ms1_3), ms2_2.Equals(ms2_3));
            //Console.WriteLine();
            //Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_1 == ms_2", "== impl?", ms2_1 == ms2_2);
            //Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_1 == ms_3", "== impl?", ms2_1 == ms2_3);
            //Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_2 == ms_3", "== impl?", ms2_2 == ms2_3);
            ////Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_1 == ms_2", ms1_1 == ms1_2, ms2_1 == ms2_2);
            ////Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_1 == ms_3", ms1_1 == ms1_3, ms2_1 == ms2_3);
            ////Console.WriteLine("{0,-40}{1,-10}{2,-10}", "ms_2 == ms_3", ms1_2 == ms1_3, ms2_2 == ms2_3);
            //Console.WriteLine();
            #endregion

            #region reference-types
            Console.WriteLine("\n\n\n");
            Console.WriteLine("****************************** REFERENCE-TYPE ******************************");

            string s1 = "string";
            string s2 = s1;
            //string s3 = "string";
            char[] aString = { 's', 't', 'r', 'i', 'n', 'g' };
            string s3 = new string(aString);

            Console.WriteLine("===== STRING =====");
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "Object.ReferenceEquals(s1, s2)", Object.ReferenceEquals(s1, s2));
            Console.WriteLine("{0,-40}{1}", "Object.ReferenceEquals(s1, s3)", Object.ReferenceEquals(s1, s3));
            Console.WriteLine("{0,-40}{1}", "Object.ReferenceEquals(s2, s3)", Object.ReferenceEquals(s2, s3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "Object.Equals(s1, s2)", Object.Equals(s1, s2));
            Console.WriteLine("{0,-40}{1}", "Object.Equals(s1, s3)", Object.Equals(s1, s3));
            Console.WriteLine("{0,-40}{1}", "Object.Equals(s2, s3)", Object.Equals(s2, s3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "s1.Equals(s2)", s1.Equals(s2));
            Console.WriteLine("{0,-40}{1}", "s1.Equals(s3)", s1.Equals(s3));
            Console.WriteLine("{0,-40}{1}", "s2.Equals(s3)", s2.Equals(s3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1}", "s1 == s2", s1 == s2);
            Console.WriteLine("{0,-40}{1}", "s1 == s3", s1 == s3);
            Console.WriteLine("{0,-40}{1}", "s2 == s3", s2 == s3);
            Console.WriteLine();

            MyClass mc1_1 = new MyClass(1);
            MyClass mc1_2 = mc1_1;
            MyClass mc1_3 = new MyClass(1);

            MyClassEqualsOverride mc2_1 = new MyClassEqualsOverride(2);
            MyClassEqualsOverride mc2_2 = mc2_1;
            MyClassEqualsOverride mc2_3 = new MyClassEqualsOverride(2);

            MyClassOperatorOverloading mc3_1 = new MyClassOperatorOverloading(3);
            MyClassOperatorOverloading mc3_2 = mc3_1;
            MyClassOperatorOverloading mc3_3 = new MyClassOperatorOverloading(3);

            Console.WriteLine();
            Console.WriteLine("===== MYCLASS OPERATOR OVERLOADING =====");
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "", "MyClass", "Equals", "Equals&Operator");
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "Object.ReferenceEquals(mc_1, mc_2)", Object.ReferenceEquals(mc1_1, mc1_2), Object.ReferenceEquals(mc2_1, mc2_2), Object.ReferenceEquals(mc3_1, mc3_2));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "Object.ReferenceEquals(mc_1, mc_3)", Object.ReferenceEquals(mc1_1, mc1_3), Object.ReferenceEquals(mc2_1, mc2_3), Object.ReferenceEquals(mc3_1, mc3_3));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "Object.ReferenceEquals(mc_2, mc_3)", Object.ReferenceEquals(mc1_2, mc1_3), Object.ReferenceEquals(mc2_2, mc2_3), Object.ReferenceEquals(mc2_1, mc3_3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "Object.Equals(mc_1, mc_2)", Object.Equals(mc1_1, mc1_2), Object.Equals(mc2_1, mc2_2), Object.Equals(mc3_1, mc3_2));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "Object.Equals(mc_1, mc_3)", Object.Equals(mc1_1, mc1_3), Object.Equals(mc2_1, mc2_3), Object.Equals(mc3_1, mc3_3));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "Object.Equals(mc_2, mc_3)", Object.Equals(mc1_2, mc1_3), Object.Equals(mc2_2, mc2_3), Object.Equals(mc3_2, mc3_3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "mc_1.Equals(mc_2)", mc1_1.Equals(mc1_2), mc2_1.Equals(mc2_2), mc3_1.Equals(mc3_2));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "mc_1.Equals(mc_3)", mc1_1.Equals(mc1_3), mc2_1.Equals(mc2_3), mc3_1.Equals(mc3_3));
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "mc_2.Equals(mc_3)", mc1_2.Equals(mc1_3), mc2_2.Equals(mc2_3), mc3_2.Equals(mc3_3));
            Console.WriteLine();
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "mc_1 == mc_2", mc1_1 == mc1_2, mc2_1 == mc2_2, mc3_1 == mc3_2);
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "mc_1 == mc_3", mc1_1 == mc1_3, mc2_1 == mc2_3, mc3_1 == mc3_3);
            Console.WriteLine("{0,-40}{1,-10}{2,-10}{3,-10}", "mc_2 == mc_3", mc1_2 == mc1_3, mc2_2 == mc2_3, mc3_2 == mc3_3);
            Console.WriteLine();
            #endregion

            Console.ReadLine();
        }
    }

    struct MyStruct
    {
        public int Id;

        public MyStruct(int id)
        {
            Id = id;
        }
    }

    struct MyStructOperatorOverloading
    {
        public int Id;

        public MyStructOperatorOverloading(int id)
        {
            Id = id;
        }

        public override bool Equals(object o)
        {
            try
            {
                return this.Id == ((MyStructOperatorOverloading)o).Id;
            }
            catch
            {
                return false;
            }
        }

        public override int GetHashCode()
        {
            return Id;
            //return base.GetHashCode();
        }

        public static bool operator ==(MyStructOperatorOverloading ms1, MyStructOperatorOverloading ms2)
        {
            return ms1.Equals(ms2);
        }

        public static bool operator !=(MyStructOperatorOverloading ms1, MyStructOperatorOverloading ms2)
        {
            return !(ms1.Equals(ms2));
        }

    }

    class MyClass
    {
        public int Id { get; set; }

        public MyClass(int id)
        {
            Id = id;
        }
    }

    class MyClassEqualsOverride
    {
        public int Id { get; set; }

        public MyClassEqualsOverride(int id)
        {
            Id = id;
        }

        public override bool Equals(object o)
        {
            try
            {
                return this.Id == ((MyClassEqualsOverride)o).Id;
            }
            catch
            {
                return false;
            }
        }

        public override int GetHashCode()
        {
            return Id;
            //return base.GetHashCode();
        }
    }

    class MyClassOperatorOverloading
    {
        public int Id { get; set; }

        public MyClassOperatorOverloading(int id)
        {
            Id = id;
        }

        public override bool Equals(object o)
        {
            try
            {
                return this.Id == ((MyClassOperatorOverloading)o).Id;
            }
            catch
            {
                return false;
            }
        }

        public override int GetHashCode()
        {
            return Id;
            //return base.GetHashCode();
        }

        public static bool operator ==(MyClassOperatorOverloading mc1, MyClassOperatorOverloading mc2)
        {
            return mc1.Equals(mc2);
        }

        public static bool operator !=(MyClassOperatorOverloading mc1, MyClassOperatorOverloading mc2)
        {
            return !(mc1.Equals(mc2));
        }
    }
}
