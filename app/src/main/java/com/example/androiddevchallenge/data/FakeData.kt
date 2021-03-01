/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.model.Adaptability
import com.example.androiddevchallenge.data.model.AllAroundFriendliness
import com.example.androiddevchallenge.data.model.BreedCharacteristics
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.data.model.HealthAndGroomingNeeds
import com.example.androiddevchallenge.data.model.PhysicalNeeds
import com.example.androiddevchallenge.data.model.Trainability

val UNKNOWN_DOG_ITEM =
    DogItem(
        name = "Unknown",
        location = "Unknown",
        stars = 0,
        price = 0,
        type = "Unknown",
        desc = "Unknown",
        image = "",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 0,
                goodForNoviceOwners = 0,
                sensitivityLevel = 0,
                toleratesBeingAlone = 0,
                toleratesColdWeather = 0,
                toleratesHotWeather = 0
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 0,
                kidFriendly = 0,
                dogFriendly = 0,
                friendlyTowardStrangers = 0
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 0,
                droolingPotential = 0,
                easyToGroom = 0,
                generalHealth = 0,
                potentialForWeightGain = 0,
                size = 0
            ),
            trainability = Trainability(
                easyToTrain = 0,
                intelligence = 0,
                potentialForMouthiness = 0,
                preyDrive = 0,
                tendencyToBarkOrHowl = 0,
                wanderlustPotential = 0
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 0,
                intensity = 0,
                exerciseNeeds = 0,
                potentialForPlayfulness = 0
            )
        ),
        source = "https://www.google.com"
    )

val dogsList = mutableListOf(
    DogItem(
        name = "Happy",
        location = "America",
        stars = 3,
        price = 250,
        type = "Afador",
        desc = "The Afador is a mixed breed dog–a cross between the Afghan Hound and Labrador Retriever dog breeds. Loyal, energetic, and affectionate, these pups inherited some of the best qualities from both of their parents.\n" +
            "\n" +
            "Afadors are also sometimes known as the Afghan Lab. You can find these mixed breed dogs in shelters and breed specific rescues, so remember to always adopt! Don’t shop if you’re looking to add an Afador to your home!\n" +
            "\n" +
            "Afadors make excellent family pets, although they do better with older children and seasoned dog owners who can give the breed the training and attention they require. Afadors also make for good guard dogs, and they’re alert to strangers. The mixed breed is very energetic and athletic, so access to a safe outdoor space is preferred.\n" +
            "\n" +
            "See below for all mixed dog breed traits and facts about Afadors!",
        image = "https://www.dogtime.com/assets/uploads/2019/08/afador-mixed-dog-breed-pictures-1-1442x1328.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 1,
                goodForNoviceOwners = 1,
                sensitivityLevel = 3,
                toleratesBeingAlone = 3,
                toleratesColdWeather = 4,
                toleratesHotWeather = 1
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 4,
                kidFriendly = 2,
                dogFriendly = 3,
                friendlyTowardStrangers = 1
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 4,
                droolingPotential = 3,
                easyToGroom = 2,
                generalHealth = 3,
                potentialForWeightGain = 4,
                size = 4
            ),
            trainability = Trainability(
                easyToTrain = 1,
                intelligence = 5,
                potentialForMouthiness = 4,
                preyDrive = 4,
                tendencyToBarkOrHowl = 4,
                wanderlustPotential = 4
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 4,
                intensity = 4,
                exerciseNeeds = 4,
                potentialForPlayfulness = 3
            )
        ),
        source = "https://dogtime.com/dog-breeds/afador"
    ),
    DogItem(
        name = "Jenny",
        location = "England",
        stars = 4,
        price = 400,
        type = "Affenhuahua",
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
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 4,
                goodForNoviceOwners = 4,
                sensitivityLevel = 4,
                toleratesBeingAlone = 1,
                toleratesColdWeather = 2,
                toleratesHotWeather = 3
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 4,
                kidFriendly = 3,
                dogFriendly = 2,
                friendlyTowardStrangers = 2
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 2,
                droolingPotential = 1,
                easyToGroom = 4,
                generalHealth = 4,
                potentialForWeightGain = 5,
                size = 1
            ),
            trainability = Trainability(
                easyToTrain = 3,
                intelligence = 3,
                potentialForMouthiness = 4,
                preyDrive = 2,
                tendencyToBarkOrHowl = 4,
                wanderlustPotential = 2
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 4,
                intensity = 3,
                exerciseNeeds = 3,
                potentialForPlayfulness = 3
            )
        ),
        source = "https://dogtime.com/dog-breeds/affenhuahua"
    ),
    DogItem(
        name = "Deejay",
        location = "Germany",
        stars = 3,
        price = 650,
        type = "Affenpinscher",
        desc = "Dogs of the Affenpinscher breed were originally created to act as ratters in homes, stables, and shops. Bred down in size, they moved up in the world, becoming ladies’ companions. Today, they are happy, mischievous companion dogs.\n" +
            "\n" +
            "Although these are purebred dogs, you may still find them in shelters and rescues. Remember to adopt! Don’t shop if you want to bring a dog home.\n" +
            "\n" +
            "Affenpinschers adore their humans, but they prefer the company of adults. They don’t take well to rough play, chasing, or being held on a lap without the freedom to jump down on their own time. But grown-up pet parents will find that these dogs are loving, loyal, and protective despite their small size.\n" +
            "\n" +
            "See below for complete list of dog breed traits and facts about Affenpinschers!",
        image = "https://dogtime.com/assets/uploads/gallery/affenpinscher-dog-breed-pictures/10-floorhappy.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 4,
                goodForNoviceOwners = 4,
                sensitivityLevel = 4,
                toleratesBeingAlone = 1,
                toleratesColdWeather = 2,
                toleratesHotWeather = 3
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 5,
                kidFriendly = 1,
                dogFriendly = 4,
                friendlyTowardStrangers = 3
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 1,
                droolingPotential = 1,
                easyToGroom = 3,
                generalHealth = 4,
                potentialForWeightGain = 3,
                size = 1
            ),
            trainability = Trainability(
                easyToTrain = 2,
                intelligence = 4,
                potentialForMouthiness = 4,
                preyDrive = 3,
                tendencyToBarkOrHowl = 2,
                wanderlustPotential = 2
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 4,
                intensity = 3,
                exerciseNeeds = 3,
                potentialForPlayfulness = 4
            )
        ),
        source = "https://dogtime.com/dog-breeds/Affenpinscher"
    ),
    DogItem(
        name = "Bestie",
        location = "Japan",
        stars = 4,
        price = 550,
        type = "Basset Hound",
        desc = "The Basset Hound dog breed was bred for hunting small game such as rabbits and is still used for this purpose in some parts of the United States. When they’re not on the trail of a bunny, they’re laid-back family friends who love kids.\n" +
            "\n" +
            "Although they’re purebred dogs, you may find Bassets in shelters or in the care of rescue groups. If this is the breed for you, opt to adopt if possible!\n" +
            "\n" +
            "Adaptable, affectionate, and relaxed, these dogs will even appeal to novice pet parents who are new to the dog world. You will, however, need to commit to at least moderate exercise and feed your pup an appropriate diet, as their easygoing demeanor could lead to weight gain and the health issues that can come with. If you can keep your Basset active, in spite of how much they may protest, you’ll have a loving companion who will stick around for many years to come.\n" +
            "\n" +
            "DogTime recommends this dog bed to give a good night’s sleep to your medium-sized Basset Hound. You should also pick up this squeaker rope toy to help keep your low energy pup active!\n" +
            "\n" +
            "See below for complete list of Basset Hound dog breed facts and characteristics!",
        image = "https://dogtime.com/assets/uploads/gallery/basset-hound-dog-breed-pictures/6-face2.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 4,
                goodForNoviceOwners = 3,
                sensitivityLevel = 4,
                toleratesBeingAlone = 1,
                toleratesColdWeather = 2,
                toleratesHotWeather = 4
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 5,
                kidFriendly = 5,
                dogFriendly = 5,
                friendlyTowardStrangers = 5
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 4,
                droolingPotential = 4,
                easyToGroom = 5,
                generalHealth = 1,
                potentialForWeightGain = 5,
                size = 3
            ),
            trainability = Trainability(
                easyToTrain = 2,
                intelligence = 4,
                potentialForMouthiness = 3,
                preyDrive = 5,
                tendencyToBarkOrHowl = 4,
                wanderlustPotential = 5
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 2,
                intensity = 2,
                exerciseNeeds = 2,
                potentialForPlayfulness = 2
            )
        ),
        source = "https://dogtime.com/dog-breeds/basset-hound"
    ),
    DogItem(
        name = "Caroline",
        location = "South Korea",
        stars = 3,
        price = 120,
        type = "Carolina Dog",
        desc = "Indigenous to the United States, the Carolina Dog is a rare, primitive dog breed and relatively new to domesticity. They are medium in size, agile, and independent; they’re also known for being very clean dogs.\n" +
            "\n" +
            "The Carolina Dog is also sometimes called the Yellow Dog, the American Dingo, the Dixie Dingo, and the Yaller. They were feral and lived in the Southeastern United States for hundreds of years, and they’re still found in the wild in some parts of Georgia and South Carolina.\n" +
            "\n" +
            "Carolina Dogs are probably not going to be overly affectionate but will form close bonds with their humans. Show them strong leadership and let them know you’re in charge when training. They may act reserved and wary of strangers, but they don’t tend to behave aggressively.\n" +
            "\n" +
            "Canines of this breed are pack dogs through and through, and they’d thrive in multi-dog and person homes, forming loving bonds with other dogs and humans alike. They have a high prey drive, so you must watch them closely around other small animals. They love big families and big homes with yards where they can run around. Carolina Dogs are incredibly loyal to their humans and sweet and playful with kids.\n" +
            "\n" +
            "DogTime recommends this dog bed to give a good night’s sleep to your medium-sized Carolina Dog. You should also pick up this dog fetch toy to help burn off your pup’s high energy!\n" +
            "\n" +
            "See below for complete list of Carolina Dog breed facts and traits!",
        image = "https://dogtime.com/assets/uploads/gallery/carolina-dog-breed-pictures/carolina-dog-breed-pictures-4.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 2,
                goodForNoviceOwners = 2,
                sensitivityLevel = 2,
                toleratesBeingAlone = 1,
                toleratesColdWeather = 4,
                toleratesHotWeather = 4
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 2,
                kidFriendly = 3,
                dogFriendly = 5,
                friendlyTowardStrangers = 2
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 4,
                droolingPotential = 2,
                easyToGroom = 4,
                generalHealth = 5,
                potentialForWeightGain = 4,
                size = 3
            ),
            trainability = Trainability(
                easyToTrain = 2,
                intelligence = 4,
                potentialForMouthiness = 2,
                preyDrive = 5,
                tendencyToBarkOrHowl = 1,
                wanderlustPotential = 5
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 4,
                intensity = 5,
                exerciseNeeds = 4,
                potentialForPlayfulness = 3
            )
        ),
        source = "https://dogtime.com/dog-breeds/carolina-dog"
    ),
    DogItem(
        name = "Sally",
        location = "Brazil",
        stars = 2,
        price = 600,
        type = "Cavalier King Charles Spaniel",
        desc = "Although they’re born to be a companion, the Cavalier King Charles Spaniel dog breed retains the sporty nature of their spaniel ancestors. If they’re not sitting on a lap or getting a belly rub, nothing makes them happier than to flush a bird and then attempt to retrieve it.\n" +
            "\n" +
            "Although these are purebred dogs, you may still find them in shelters and rescues. Remember to adopt! Don’t shop if you want to bring a dog home.\n" +
            "\n" +
            "One of the largest of the toy breeds, Cavaliers are often as athletic as a true sporting breed and enjoy hiking, running on the beach, and dog sports such as agility, flyball and rally. Some have even shown their prowess as hunting dogs. The more restful members of the breed find success as family friends and therapy dogs.\n" +
            "\n" +
            "See below for complete list of Cavalier King Charles Spaniel characteristics!",
        image = "https://dogtime.com/assets/uploads/gallery/cavalier-king-charles-spaniel-dog-breed-pictures/6-sittingforward.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 5,
                goodForNoviceOwners = 5,
                sensitivityLevel = 5,
                toleratesBeingAlone = 1,
                toleratesColdWeather = 3,
                toleratesHotWeather = 2
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 5,
                kidFriendly = 5,
                dogFriendly = 5,
                friendlyTowardStrangers = 5
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 3,
                droolingPotential = 1,
                easyToGroom = 4,
                generalHealth = 4,
                potentialForWeightGain = 4,
                size = 2
            ),
            trainability = Trainability(
                easyToTrain = 4,
                intelligence = 4,
                potentialForMouthiness = 3,
                preyDrive = 3,
                tendencyToBarkOrHowl = 2,
                wanderlustPotential = 2
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 3,
                intensity = 2,
                exerciseNeeds = 4,
                potentialForPlayfulness = 5
            )
        ),
        source = "https://dogtime.com/dog-breeds/cavalier-king-charles-spaniel#/slide/1"
    ),
    DogItem(
        name = "Johnny",
        location = "Egypt",
        stars = 1,
        price = 500,
        type = "Central Asian Shepherd Dog",
        desc = "The Central Asian Shepherd Dog is a big, strong, and independent dog breed. These purebred dogs go by several other names, including Central Asian Ovtcharka, Middle Asian Ovtcharka, and Mid-Asian Shepherd. One of the oldest breeds, these pups genetics can be traced back over 5,000 years.\n" +
            "\n" +
            "Despite their purebred status, you may find these dogs in shelters and breed specific rescues, so remember to adopt! Don’t shop!\n" +
            "\n" +
            "The Central Asian Shepherd Dog would be a great addition for a person or family in a home with a secure yard, and they thrive in cooler climates. While active outdoors, these dogs are fairly calm and quiet indoors. They can be playful and are affectionate and protective of their families but are not recommended for first time dog parents.\n" +
            "\n" +
            "See below for complete list of dog breed traits and facts about Central Asian Shepherd Dogs!",
        image = "https://dogtime.com/assets/uploads/gallery/central-asian-shepherd-dog-breed-pictures/central-asian-shepherd-dog-breed-pictures-3.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 1,
                goodForNoviceOwners = 1,
                sensitivityLevel = 4,
                toleratesBeingAlone = 2,
                toleratesColdWeather = 4,
                toleratesHotWeather = 2
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 3,
                kidFriendly = 3,
                dogFriendly = 4,
                friendlyTowardStrangers = 2
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 4,
                droolingPotential = 5,
                easyToGroom = 5,
                generalHealth = 5,
                potentialForWeightGain = 3,
                size = 4
            ),
            trainability = Trainability(
                easyToTrain = 2,
                intelligence = 5,
                potentialForMouthiness = 2,
                preyDrive = 1,
                tendencyToBarkOrHowl = 3,
                wanderlustPotential = 2
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 3,
                intensity = 3,
                exerciseNeeds = 4,
                potentialForPlayfulness = 2
            )
        ),
        source = "https://dogtime.com/dog-breeds/central-asian-shepherd-dog#/slide/1"
    ),
    DogItem(
        name = "Bts",
        location = "Argentina",
        stars = 3,
        price = 240,
        type = "Dogo Argentino",
        desc = "The Dogo Argentino, sometimes called the Argentinian Mastiff or the Argentine Dogo, is a strong, athletic, and loyal breed. They can be both fierce hunters and gentle protectors of their humans. They have a high prey drive, a strong will, and, at times, a distrust of strangers and other animals, all of which require an experienced dog owner to handle the breed.\n" +
            "\n" +
            "Dogo Argentino puppies need lots of physical activity and mental stimulation along with patient training; otherwise, they can become bored and destructive. Dogo Argentinos are often used to help with big-game hunting, though they are also trained for police work, search and rescue, military work, and as service dogs.\n" +
            "\n" +
            "\n" +
            "With proper training, they can make an awesome family companion and watchdog.\n" +
            "\n" +
            "See below for full list of dog breed traits and facts about Dogo Argentinos!",
        image = "https://dogtime.com/assets/uploads/gallery/dogo-argentino-breed-pictures/dogo-argentino-breed-pictures-1.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 1,
                goodForNoviceOwners = 1,
                sensitivityLevel = 3,
                toleratesBeingAlone = 2,
                toleratesColdWeather = 2,
                toleratesHotWeather = 4
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 4,
                kidFriendly = 2,
                dogFriendly = 2,
                friendlyTowardStrangers = 2
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 1,
                droolingPotential = 3,
                easyToGroom = 4,
                generalHealth = 3,
                potentialForWeightGain = 2,
                size = 4
            ),
            trainability = Trainability(
                easyToTrain = 2,
                intelligence = 3,
                potentialForMouthiness = 2,
                preyDrive = 5,
                tendencyToBarkOrHowl = 2,
                wanderlustPotential = 4
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 4,
                intensity = 4,
                exerciseNeeds = 4,
                potentialForPlayfulness = 3
            )
        ),
        source = "https://dogtime.com/dog-breeds/dogo-argentino#/slide/1"
    ),
    DogItem(
        name = "Gartner",
        location = "Mexico",
        stars = 5,
        price = 560,
        type = "Doxiepoo",
        desc = "If you were the type of kid who wasn’t afraid to choose the “mystery” flavor of candy in a bag, a Dachshund Poodle — or Doxiepoo — may be for you. While this mixed breed can have famously endless combinations of traits, they are known for being affectionate, intelligent, and playful.\n" +
            "\n" +
            "The list of names the Doxiepoo is known by is as long as the parent Dachshund: Doodle, Dachdoodle, Doxiedoodle, Doxiepoodle, Dachshunddoodle, and Dachshundpoo. This is one of the most unpredictable pairings among mixed breeds, even within a single litter. This means they often end up in shelters. However, with such winning traits, they are wonderfully adoptable dogs. And, as one of the most affectionate mixed breeds, they’ll fall in love with you before you leave the shelter.\n" +
            "\n" +
            "Because they’re so loving and loyal, Doxiepoos work best with families who don’t mind spending plenty of time with them. They do well with children, but they do best in single-pet homes. Vigilant watchdogs, Doxiepoos may be “yappy,” so owners should be prepared. Also, because it’s hard to know how this mix may turn out, owners who need “hypoallergenic” dogs should probably meet this mixed breed before bringing one home. Doxiepoos are energetic but adapt well to both apartments and houses, provided they are given enough exercise time.\n" +
            "\n" +
            "See below for all Doxiepoo facts and mixed dog breed characteristics!",
        image = "https://dogtime.com/assets/uploads/gallery/doxiepoo-mixed-dog-breed-pictures/doxiepoo-mixed-dog-breed-pictures-2.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 5,
                goodForNoviceOwners = 3,
                sensitivityLevel = 4,
                toleratesBeingAlone = 2,
                toleratesColdWeather = 3,
                toleratesHotWeather = 3
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 5,
                kidFriendly = 2,
                dogFriendly = 2,
                friendlyTowardStrangers = 3
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 3,
                droolingPotential = 0,
                easyToGroom = 3,
                generalHealth = 2,
                potentialForWeightGain = 4,
                size = 2
            ),
            trainability = Trainability(
                easyToTrain = 3,
                intelligence = 5,
                potentialForMouthiness = 3,
                preyDrive = 4,
                tendencyToBarkOrHowl = 5,
                wanderlustPotential = 4
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 4,
                intensity = 4,
                exerciseNeeds = 4,
                potentialForPlayfulness = 5
            )
        ),
        source = "https://dogtime.com/dog-breeds/doxiepoo#/slide/1"
    ),
    DogItem(
        name = "Oliver",
        location = "Netherlands",
        stars = 4,
        price = 720,
        type = "Drentsche Patrijshond",
        desc = "The Drentsche Patrijshond is a purebred dog hailing from the Netherlands. Intelligent, loyal, and sensitive, these pups have some of the best qualities of any dog breed.\n" +
            "\n" +
            "Drentsche Patrijshonds go by several other names, including Dutch Partridge Dog and Drent. You may find these beautiful and versatile purebred dogs in your local shelters and breed specific rescues. Remember that it’s always better to adopt and not shop!\n" +
            "\n" +
            "These great pooches make excellent all-around pets. They’re able to live with urban dwellers in city apartments but are better suited for bigger homes with a yard so they can expend their energy. From single-person households to larger sized families, these pups fit in with anyone. If you want a loyal companion who loves to please, then the Drentsche Patrijschond might be just right for you!\n" +
            "\n" +
            "See below for all Drentsche Patrijshond facts and dog breed characteristics!",
        image = "https://dogtime.com/assets/uploads/gallery/drentsche-patrijshond-dog-breed-pictures/drentsche-patrijshond-dog-breed-pictures-5.jpg",
        breedCharacteristics = BreedCharacteristics(
            adaptability = Adaptability(
                adatpsWellToApartmentLiving = 3,
                goodForNoviceOwners = 2,
                sensitivityLevel = 4,
                toleratesBeingAlone = 3,
                toleratesColdWeather = 4,
                toleratesHotWeather = 3
            ),
            allAroundFriendliness = AllAroundFriendliness(
                affectionateWithFamily = 5,
                kidFriendly = 4,
                dogFriendly = 4,
                friendlyTowardStrangers = 3
            ),
            healthAndGroomingNeeds = HealthAndGroomingNeeds(
                amountOfShedding = 4,
                droolingPotential = 3,
                easyToGroom = 3,
                generalHealth = 4,
                potentialForWeightGain = 2,
                size = 3
            ),
            trainability = Trainability(
                easyToTrain = 2,
                intelligence = 4,
                potentialForMouthiness = 3,
                preyDrive = 4,
                tendencyToBarkOrHowl = 2,
                wanderlustPotential = 1
            ),
            physicalNeeds = PhysicalNeeds(
                energyLevel = 5,
                intensity = 3,
                exerciseNeeds = 4,
                potentialForPlayfulness = 4
            )
        ),
        source = "https://dogtime.com/dog-breeds/drentsche-patrijshond#/slide/1"
    ),
)
