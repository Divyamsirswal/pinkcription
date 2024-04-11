# Encryption Process
1. Take `username` and `password` from user and validate it
2. Combine `username` and `password` to create a new `hash_string`
3. Pass this to `hashFunction()` which will give a `key` of fixed length
4. this `key` will be then passed to a function, `encrypt()`,that will encrypt the inputted file
5. now save the file with extension `.pink`

# Errors
1. `Error 101` : failed to initialize sha256 encryption algorithm inside HashString.java