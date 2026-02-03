class Sstr{
    public static void main(String[] args) {
        String str = "roshan";
        int vowels = 0; // Corrected spelling to match usage
        int consonants = 0; // Corrected spelling

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
              
            } else if (ch >= 'a' && ch <= 'z') {
             consonants++;
            }
        }
        
        // Print statement moved outside the loop to show final totals
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
