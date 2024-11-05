using System;

namespace CalculadoraCientifica
{
    class Program
    {
        static void Main(string[] args)
        {
            bool continuar = true;

            while (continuar)
            {
                string choice = ExibirMenu();

                switch (choice)
                {
                    case "1":
                        ExecutarOperacaoBinaria("adição", Adicionar);
                        break;
                    case "2":
                        ExecutarOperacaoBinaria("subtração", Subtrair);
                        break;
                    case "3":
                        ExecutarOperacaoBinaria("multiplicação", Multiplicar);
                        break;
                    case "4":
                        ExecutarOperacaoBinaria("divisão", Dividir);
                        break;
                    case "5":
                        ExecutarOperacaoUnaria("seno", Math.Sin);
                        break;
                    case "6":
                        ExecutarOperacaoUnaria("cosseno", Math.Cos);
                        break;
                    case "7":
                        ExecutarOperacaoUnaria("tangente", Math.Tan);
                        break;
                    case "8":
                        ExecutarOperacaoUnaria("logaritmo", Math.Log);
                        break;
                    case "9":
                        ExecutarOperacaoUnaria("raiz quadrada", Math.Sqrt);
                        break;
                    case "0":
                        continuar = false;
                        break;
                    default:
                        Console.WriteLine("Opção inválida!");
                        break;
                }

                Console.WriteLine("\nPressione qualquer tecla para continuar...");
                Console.ReadKey();
                Console.Clear();
            }
        }

        static string ExibirMenu()
        {
            Console.WriteLine("Calculadora Científica");
            Console.WriteLine("Escolha uma operação:");
            Console.WriteLine("1. Adição");
            Console.WriteLine("2. Subtração");
            Console.WriteLine("3. Multiplicação");
            Console.WriteLine("4. Divisão");
            Console.WriteLine("5. Seno");
            Console.WriteLine("6. Cosseno");
            Console.WriteLine("7. Tangente");
            Console.WriteLine("8. Logaritmo");
            Console.WriteLine("9. Raiz Quadrada");
            Console.WriteLine("0. Sair");
            return Console.ReadLine();
        }

        static void ExecutarOperacaoBinaria(string operacao, Func<double, double, double> metodo)
        {
            double num1 = ObterNumeroDoUsuario("Digite o primeiro número:");
            double num2 = ObterNumeroDoUsuario("Digite o segundo número:");
            try
            {
                Console.WriteLine($"Resultado ({operacao}): {metodo(num1, num2)}");
            }
            catch (DivideByZeroException)
            {
                Console.WriteLine("Erro: Divisão por zero!");
            }
        }

        static void ExecutarOperacaoUnaria(string operacao, Func<double, double> metodo)
        {
            double numero = ObterNumeroDoUsuario("Digite o número:");
            Console.WriteLine($"Resultado ({operacao}): {metodo(numero)}");
        }

        static double ObterNumeroDoUsuario(string mensagem)
        {
            double numero;
            while (true)
            {
                Console.WriteLine(mensagem);
                if (double.TryParse(Console.ReadLine(), out numero))
                    return numero;
                Console.WriteLine("Entrada inválida. Por favor, digite um número válido.");
            }
        }

        // Métodos das operações matemáticas binárias
        static double Adicionar(double a, double b) => a + b;
        static double Subtrair(double a, double b) => a - b;
        static double Multiplicar(double a, double b) => a * b;
        static double Dividir(double a, double b) => b != 0 ? a / b : throw new DivideByZeroException();
    }
}