package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.model.Adaptability
import com.example.androiddevchallenge.data.model.DogItem


val UNKNOWN_DOG_ITEM =
    DogItem(
        name = "Unknown",
        desc = "Unknown",
        image = "",
        Adaptability(
            adatpsWellToApartmentLiving = 0,
            goodForNoviceOwners = 0,
            sensitivityLevel = 0,
            toleratesBeingAlone = 0,
            toleratesColdWeather = 0,
            toleratesHotWeather = 0
        ),
        source = "https://www.google.com"
    )

val dogsList = mutableListOf(
    DogItem(
        name = "Afador",
        desc = "The Afador is a mixed breed dog–a cross between the Afghan Hound and Labrador Retriever dog breeds. Loyal, energetic, and affectionate, these pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "Afadors are also sometimes known as the Afghan Lab. You can find these mixed breed dogs in shelters and breed specific rescues, so remember to always adopt! Don’t shop if you’re looking to add an Afador to your home!\n" +
                "\n" +
                "Afadors make excellent family pets, although they do better with older children and seasoned dog owners who can give the breed the training and attention they require. Afadors also make for good guard dogs, and they’re alert to strangers. The mixed breed is very energetic and athletic, so access to a safe outdoor space is preferred.\n" +
                "\n" +
                "See below for all mixed dog breed traits and facts about Afadors!",
        image = "https://www.dogtime.com/assets/uploads/2019/08/afador-mixed-dog-breed-pictures-1-1442x1328.jpg",
        Adaptability(
            adatpsWellToApartmentLiving = 1,
            goodForNoviceOwners = 1,
            sensitivityLevel = 3,
            toleratesBeingAlone = 3,
            toleratesColdWeather = 4,
            toleratesHotWeather = 1
        ),
        source = "https://dogtime.com/dog-breeds/afador"
    ),
    DogItem(
        name = "Affenhuahua",
        desc = "The Affenhuahua is a mixed breed dog–a cross between the Chihuahua and Affenpinscher dog breeds. Petite, sassy, and highly energetic, these pups inherited some of the best traits from both of their parents.\n" +
                "\n" +
                "Affenhuahuas are also sometimes called Affen Chi. Despite their status as a designer breed, you can find these mixed breed dogs in shelters and rescues, so adopt! Don’t shop!\n" +
                "\n" +
                "These compact, cute pups make great apartment dogs for active city dwellers, though they can also thrive in small or single-person households. They can also be a bit territorial and yappy. If you want an energetic, sassy dog who will keep you on your toes, alert you to any dangers, and love you unconditionally, the Affenhuahua may be the right dog for you!\n" +
                "\n" +
                "DogTime recommends this carrier for traveling with your small Affenhuahua.  You should also pick up this dog water bottle for any outdoor adventures you have with your pup!\n" +
                "\n" +
                "See below for all mixed dog breed traits and facts about Affenhuahuas!",
        image = "https://www.dogtime.com/assets/uploads/2020/02/affenhuahua-mixed-dog-breed-pictures-1-1442x960.jpg",
        Adaptability(
            adatpsWellToApartmentLiving = 4,
            goodForNoviceOwners = 4,
            sensitivityLevel = 4,
            toleratesBeingAlone = 1,
            toleratesColdWeather = 2,
            toleratesHotWeather = 3
        ),
        source = "https://dogtime.com/dog-breeds/affenhuahua"
    ),
    DogItem(
        name = "Affenpinscher",
        desc = "Dogs of the Affenpinscher breed were originally created to act as ratters in homes, stables, and shops. Bred down in size, they moved up in the world, becoming ladies’ companions. Today, they are happy, mischievous companion dogs.\n" +
                "\n" +
                "Although these are purebred dogs, you may still find them in shelters and rescues. Remember to adopt! Don’t shop if you want to bring a dog home.\n" +
                "\n" +
                "Affenpinschers adore their humans, but they prefer the company of adults. They don’t take well to rough play, chasing, or being held on a lap without the freedom to jump down on their own time. But grown-up pet parents will find that these dogs are loving, loyal, and protective despite their small size.\n" +
                "\n" +
                "See below for complete list of dog breed traits and facts about Affenpinschers!",
        image = "https://dogtime.com/assets/uploads/gallery/affenpinscher-dog-breed-pictures/10-floorhappy.jpg",
        Adaptability(
            adatpsWellToApartmentLiving = 4,
            goodForNoviceOwners = 4,
            sensitivityLevel = 4,
            toleratesBeingAlone = 1,
            toleratesColdWeather = 2,
            toleratesHotWeather = 3
        ),
        source = "https://dogtime.com/dog-breeds/Affenpinscher"
    ),
    DogItem(
        name = "Barbet",
        desc = "This woolly sporting dog breed is fun-loving and smart. The Barbet was bred for retrieving waterfowl for hunters — and has the webbed feet to prove it — but they’re also a talented agility competitor in their native France.\n" +
                "\n" +
                "Although these are purebred dogs, you may find them in the care of shelters and rescue groups. Remember to adopt! Don’t shop if you want to bring one of these dogs home.\n" +
                "\n" +
                "Barbets do best with experienced pet parents. They have high energy and would love to participate in dog sports like agility competitions. If you can meet the breed’s needs, you’ll have an affectionate family member who even does well with kids and other dogs.\n" +
                "\n" +
                "See below for full list dog breed traits and facts about Barbets!",
        image = "https://dogtime.com/assets/uploads/gallery/barbet-dog-breed-pictures/leash-2_680-453.jpg",
        Adaptability(
            adatpsWellToApartmentLiving = 4,
            goodForNoviceOwners = 4,
            sensitivityLevel = 4,
            toleratesBeingAlone = 1,
            toleratesColdWeather = 2,
            toleratesHotWeather = 3
        ),
        source = "https://dogtime.com/dog-breeds/barbet#/slide/1"
    )




)
