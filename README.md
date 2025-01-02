# Substitution Cipher Implementation

## Overview
This Java program implements a substitution cipher, a simple encryption technique where each letter in the plaintext is replaced by a letter in a predefined substitution key. The key is generated using a keyword, ensuring unique and reproducible encryption and decryption.

## What I Learned
- **String Manipulation**: Learned how to process and modify strings to create a substitution key based on a keyword.
- **Substitution Cipher Algorithm**: Gained an understanding of how the substitution cipher works, including how to generate a key and use it for both encryption and decryption.
- **File Handling in Java**: I learned how to read from and write to files in Java, making the program capable of processing plaintext and ciphertext stored in external files.
- **Use of Loops and Conditionals**: Enhanced my understanding of loops and conditionals, as they were essential for iterating over the plaintext and ciphertext during the encryption and decryption processes.
- **Error Handling**: Improved my ability to handle I/O exceptions in Java when working with files.
- **Efficiency in Searching**: Learned how to efficiently search for characters in strings using methods like `indexOf` and how to append non-repetitive characters to a string.
  
## How It Works
1. **Substitution Key Generation**:
   - The keyword is processed to remove duplicate letters.
   - The remaining letters of the alphabet (in reverse order) are appended to the keyword to form a complete substitution key.

2. **Encryption**:
   - Each character in the plaintext is replaced with the corresponding character from the substitution key based on its position in the alphabet.

3. **Decryption**:
   - The ciphertext characters are mapped back to the original alphabet using the substitution key.

4. **File Handling**:
   - The program reads plaintext from a file, encrypts it, and saves the ciphertext to a file.
   - It can also read ciphertext from a file, decrypt it, and save the plaintext to a file.

## Usage
### Input
- **Keyword**: Used to generate the substitution key.
- **Plaintext File**: The file containing the text to encrypt.
- **Ciphertext File**: The file containing the text to decrypt.

### Output
- Encrypted text is saved to `ciphertext.txt`.
- Decrypted text is saved to `plaintext.txt`.

## Running the Program
1. Compile the program:
   ```bash
   javac task2.java
