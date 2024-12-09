import numpy as np
import matplotlib.pyplot as plt

# Define the function H(s)
def H(s): 
    return 1 / ((1 + 0.1 * s) * (1 + 0.1 * s))

# Define the range of omega (imaginary part of s)
omega = np.linspace(-100, 100, 1000)  # range from -100 to 100
s = 1j * omega  # purely imaginary s

# Calculate H(s)
H_values = H(s)

# Compute outputs for specific input frequencies
specific_omegas = [-50, 0, 10, 20, 30, 40, 50]
specific_s = 1j * np.array(specific_omegas)
specific_H = H(specific_s)

# Plot the output space
plt.figure(figsize=(8, 8))
plt.plot(H_values.real, H_values.imag, label='H(s) output space', color='blue')
plt.scatter(specific_H.real, specific_H.imag, color='red', label='Specific inputs')
for omega, h_val in zip(specific_omegas, specific_H):
    plt.annotate(f'ω={omega}', (h_val.real, h_val.imag), textcoords="offset points", xytext=(-10, 10), ha='center')

# Plot configuration
plt.axhline(0, color='black', linewidth=0.5, linestyle='--')
plt.axvline(0, color='black', linewidth=0.5, linestyle='--')
plt.title('Output Space of H(s)')
plt.xlabel('Re(H(s))')
plt.ylabel('Im(H(s))')
plt.grid()
plt.legend()
plt.axis('equal')
plt.show()
