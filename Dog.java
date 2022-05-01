class Dog{
    String name;
    public static void main(String[] args){
        //Make a dog object and access it
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";

        //Make dog array
        Dog[] mydogs = new Dog[3];

        //put some dogs in it
        mydogs[0] = new Dog();
        mydogs[1] = new Dog();
        mydogs[2] = dog1;

        //Hmm what's last dogs name
        System.out.print("Last dog's name is ");
        System.out.println(mydogs[2].name);

        //Name other two dogs
        mydogs[0].name = "Tommy";
        mydogs[1].name = "Bruno";


        //Tell all the dogs to bark
        int x = 0;

        while(x < mydogs.length){
            mydogs[x].bark();
            x = x+1;
        }
    }

    public void bark(){
        System.out.println(name + " Says Ruff!");
    }
}