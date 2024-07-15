from scipy import integrate
import numpy as np
import scipy


def f(x):
    return np.sin(x ** 2)


def composite_trapezoidal_rule(lower_limit, upper_limit, function, num_intervals):
    h = (upper_limit - lower_limit) / num_intervals

    integral_sum = (function(lower_limit) + function(upper_limit)) / 2.0

    for i in range(1, num_intervals - 1):
        xi = lower_limit + i * h
        integral_sum += function(xi)

    result = h * integral_sum

    return result


def composite_simpsons_3_8_rule(lower_limit, upper_limit, function, num_intervals):
    h = (upper_limit - lower_limit) / num_intervals

    integral_sum = function(lower_limit) + function(upper_limit)

    for i in range(1, num_intervals - 1):
        xi = lower_limit + i * h
        coefficient = 3 if i % 3 == 0 else 3 if (i - 1) % 3 == 0 else 2
        integral_sum += coefficient * function(xi)

    result = (3 * h / 8) * integral_sum

    return result

def myf(x):
    return np.sqrt(x+1)


def part3():
    print("\n\nPart 3 Analysis:")
    true_integral, _ = integrate.quad(lambda x: np.sin(x ** 2), 0, 3)

    n = 100
    approx_trapezoid = composite_trapezoidal_rule(0, 3, f, n)
    approx_simpson = composite_simpsons_3_8_rule(0, 3, f, n)

    true_error_trapezoid = abs(true_integral - approx_trapezoid)
    true_error_simpson = abs(true_integral - approx_simpson)

    estimated_error_trapezoid = abs((composite_trapezoidal_rule(0, 3, f, n + 100) - approx_trapezoid) / 3)
    estimated_error_simpson = abs((composite_simpsons_3_8_rule(0, 3, f, n + 100) - approx_simpson) / 15)

    print(f'True Integral Value: {true_integral}')
    print(f'Approximation using Trapezoidal Rule: {approx_trapezoid}')
    print(f'Approximation using Simpson\'s 3/8 Rule: {approx_simpson}')
    print(f'True Error (Trapezoid): {true_error_trapezoid}')
    print(f'True Error (Simpson): {true_error_simpson}')
    print(f'Estimated Error (Trapezoid): {estimated_error_trapezoid}')
    print(f'Estimated Error (Simpson): {estimated_error_simpson}')

def part4():
    a = 0
    b = 0.1
    n = int(input('\nEnter Number of Sub intervals For Part 4 Solution\n'))
    true_ans = scipy.integrate.quad(myf, a, b)[0]
    estimated_trap = abs((composite_trapezoidal_rule(a, b, myf, n + 100) - composite_trapezoidal_rule(a, b, myf, n))/3)
    estimated_simpson = abs((composite_simpsons_3_8_rule(a, b, myf, n + 100) - composite_simpsons_3_8_rule(a, b, myf, n))/15)
    true_error_trapezoid = abs(true_ans - composite_trapezoidal_rule(a, b, myf, n))
    true_error_simpson = abs(true_ans - composite_simpsons_3_8_rule(a, b, myf, n))
    print(f'\nTrapezoid : {composite_trapezoidal_rule(a, b, myf, n)}\nSimpsons : {composite_simpsons_3_8_rule(a, b, myf, n)}\nTrue Error(Trapezoid) : {true_error_trapezoid}\nTrue Error(Simpsons) : {true_error_simpson}\nEstimated Error(Trapezoid) : {estimated_trap}\nEstimated Error(Simpsons) : {estimated_simpson}')


def y_list(a):
    list_y = [124, 134, 148, 156, 147, 133, 121, 109, 99, 85, 78, 89, 104, 116, 123]
    x_list = np.arange(0, 90, 6)[:len(list_y)]
    return np.interp(a, x_list, list_y)

def part6():
    print('\nPart 6 Answer')
    print(f'\nAnswer Using Trapezoidal : {composite_trapezoidal_rule(0, 84, y_list, 14)}')
    print(f'\nAnswer Using Simpsons : {composite_simpsons_3_8_rule(0, 84, y_list, 14)}')



x_values = [10, 20, 50, 100, 1000]
print("{:<30} {:<60} {:<60} {:<60} {:<60} {:<60} {:<60}".format('n', 'Trapezoidal', 'Simpsons', 'True Error (Trapezoid)', 'Estimated Error(Trapezoid)', 'True Error (Simpson)', 'Estimated Error(Simpson)'))
print('=' * 380)

for i in range(len(x_values)):
    true_integral = scipy.integrate.quad(f, 0, 3)[0]
    estimated_trapezoid = abs((composite_trapezoidal_rule(0, 3, f, x_values[i] + 100) - composite_trapezoidal_rule(0, 3, f, x_values[i]))/3)
    estimated_simp = abs((composite_simpsons_3_8_rule(0, 3, f, x_values[i] + 100) - composite_simpsons_3_8_rule(0, 3, f, x_values[i]))/15)
    true_error_trap = abs(true_integral - composite_trapezoidal_rule(0, 3, f, x_values[i]))
    true_error_simp = abs(true_integral - composite_simpsons_3_8_rule(0, 3, f, x_values[i]))
    print("{:<30} {:<60} {:<60} {:<60} {:<60} {:<60} {:<60}".format(x_values[i], composite_trapezoidal_rule(0, 3, f, x_values[i]), composite_simpsons_3_8_rule(0, 3, f, x_values[i]), true_error_trap, estimated_trapezoid, true_error_simp, estimated_simp))

part3()
part4()
part6()

