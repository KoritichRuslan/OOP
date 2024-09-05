import numpy as np

class NumberOperations:
    # Create initial list
    numbers = [10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9]
    
    # Add different types numbers to list
    numbers.extend([np.int8(3), np.int16(19), np.int64(35), np.float64(97.7)])
    
    print("Виводимо числа на екран.")
    for number in numbers:
        print(number)
    
    # Calculate average value in list
    average = round(sum(numbers) / len(numbers), 4)
    print(f"\nAverage value: {average}")
    
    # Get whole part of list elements (new list)
    intOutput = list(map(int, numbers))
    print(f"\nFormat int: {intOutput}")
    
    # Format to fractional numbers with 2 decimal places (new list)
    fractOutput = [f"{num:.2f}" for num in numbers]
    print(f"\nFormat fractional (2 decimal places):\n[{', '.join(fractOutput)}]")
    
    # Create dictionary to store elements by type
    numbers_dict = {
        int: [],
        float: [],
        np.int8: [],
        np.int16: [],
        np.int64: [],
        np.float32: [],
        np.float64: []
    }
    
    # Distribution of list elements by type using loop
    for number in numbers:
        number_type = type(number)
        if number_type in numbers_dict:
            numbers_dict[number_type].append(number)
    
    print(f"\nInt: {numbers_dict[int]}")
    print(f"Byte: {numbers_dict[np.int8]}")
    print(f"Short: {numbers_dict[np.int16]}")
    print(f"Long: {numbers_dict[np.int64]}")
    print("Float:", numbers_dict[np.float64] + numbers_dict[float])

def main():
    processor = NumberOperations()

if __name__ == "__main__":
    main()