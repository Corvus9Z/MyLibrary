package com.howtodoinjava.hibernate.test.dto.Library;

import com.howtodoinjava.hibernate.test.HibernateUtil;
import com.howtodoinjava.hibernate.test.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MainLibrary {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        PublishingHouse publishingHouse = new PublishingHouse();
//        publishingHouse.setPublishingHouseName("Libris");
//        publishingHouse.setYearsOfAppearance(1955);
//        publishingHouse.setRank(3);
//        Book book = new Book();
//        book.setTitle("Cei trei mușchetari");
//        book.setPublishingHouseBooks(publishingHouse);
//        book.setNumberOfPages(325);
//        book.setYearOfPublication(1901);
//        book.setStatus(false);
//        book.setType("Roman");
//        Author author = new Author();
//        author.setAuthorLastName("Dumas");
//        author.setAuthorFirstName("Alexander");
//        author.setGender("M");
//        author.setAge(33);
//        author.setYearsOfExperience(55);
//
//        session.persist(book);
//        session.persist(author);
//        session.persist(publishingHouse);
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose your option:");
        System.out.println("Option 1:Insert new author");
        System.out.println("Option2:Insert a new book");
        System.out.println("Option3:Insert a new publishing house");
        System.out.println("Option4:Modify author by first and last name");
        System.out.println("Option5:Modify publishing house by name ");
        System.out.println("Option6:Display all books");
        System.out.println("Option7:Display author by name and last name");
        System.out.println("Option8:Display the age and name of all the authors who participated in the writing of the chosen book ");
        System.out.println("Option9:Display the name of the publishing house and the name of the books that have the action genre ");
        System.out.println("Option10:Display the oldest book together with the name of the author/authors who contributed to its writing  ");
        System.out.println("Option11:Delete the selected publication  ");
        System.out.println("Option12:Availability check of the selected book  ");
        System.out.println("Option13:Insert authors in the list  ");
        System.out.println("Option14:Add a review and stars to a book");
        System.out.println("Option 15:Create a simple profile in our library");
        System.out.println("Option16:Borrow books if you have a profile");
        System.out.println("Option17:Exist and save");


        int option = scanner.nextInt();

        do {


            if (option == 1) {
                System.out.println("Insert author last name");
                Scanner scanner1 = new Scanner(System.in);
                String inputLastName = scanner1.nextLine();

                System.out.println("Insert author first name");
                String inputFirstName = scanner1.nextLine();
                System.out.println("Insert age");
                Integer inputAge = scanner1.nextInt();
                System.out.println("Insert years of experience");
                Integer input4YearsOfExp = scanner1.nextInt();
                System.out.println("Insert gender author");
                String inputGender = scanner1.next();

                Author authorAddNew = new Author();
                authorAddNew.setAuthorLastName(inputLastName);
                authorAddNew.setAuthorLastName(inputFirstName);
                authorAddNew.setAge(inputAge);
                authorAddNew.setYearsOfExperience(input4YearsOfExp);
                authorAddNew.setGender(inputGender);
                session.persist(authorAddNew);

                System.out.println("The author has been successfully added");
            }
            if (option == 2) {
                System.out.println("Insert book");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Insert title");
                String inputTitle = scanner1.nextLine();
                System.out.println("Insert year of publication");
                Integer inputYearsOfPublication = scanner1.nextInt();
                System.out.println("Insert type");
                String inputTypeBook = scanner1.next();
                System.out.println("Insert number of pages");
                Integer inputNumberOfPages = scanner1.nextInt();
                System.out.println("Insert status");
                Boolean inputStatusBook = scanner1.nextBoolean();
                Book bookAdd = new Book();
                bookAdd.setTitle(inputTitle);
                bookAdd.setYearOfPublication(inputYearsOfPublication);
                bookAdd.setType(inputTypeBook);
                bookAdd.setNumberOfPages(inputNumberOfPages);
                bookAdd.setStatus(inputStatusBook);
                session.persist(bookAdd);
                session.getTransaction().commit();


            }
            if (option == 3) {
                System.out.println("Insert a new publishing house");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Insert name for publishing house");
                String inputPublishingHouse = scanner1.nextLine();
                System.out.println("Insert years of appearance");
                Integer inputYearsOfAppereance = scanner1.nextInt();
                System.out.println("Insert rank");
                Integer inputRankHouse = scanner1.nextInt();
                PublishingHouse publishingHouse1 = new PublishingHouse();
                publishingHouse1.setPublishingHouseName(inputPublishingHouse);
                publishingHouse1.setYearsOfAppearance(inputYearsOfAppereance);
                publishingHouse1.setRank(inputRankHouse);
            }
            if (option == 4) {
                System.out.println("Add the name of the author you want me to modify");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Add the last name");
                String inputLastName = scanner1.nextLine();
                System.out.println("Add the first name");
                String inputFirstName = scanner1.nextLine();
                System.out.println("Add the new last name");
                String inputNewFirstName = scanner1.nextLine();
                System.out.println("Add the new first name");
                String inputNewLastName = scanner1.nextLine();

                Query query = session.createQuery("from Author where authorLastName=: newLastName and authorFirstName=: newFirstName");
                query.setParameter("newLastName", inputLastName);
                query.setParameter("newFirstName", inputFirstName);
                List list = query.getResultList();

                Object o = list.get(0);
                Author x = (Author) o;
                x.setAuthorLastName(inputNewFirstName);
                x.setAuthorLastName(inputNewLastName);
                session.update(x);


            }
            if (option == 5) {
                System.out.println("Add the name of the publisher you want to modify");
                Scanner scanner1 = new Scanner(System.in);
                String inputPublisher = scanner1.nextLine();
                System.out.println("Add the new name of the publisher");
                String inputPublisherModify = scanner1.nextLine();
                Query query = session.createQuery("from PublishingHouse where PublishingHouseName=:newName");
                query.setParameter("newName", inputPublisher);

                List list = query.getResultList();
                Object o = list.get(0);
                PublishingHouse x = (PublishingHouse) o;
                x.setPublishingHouseName(inputPublisherModify);
                session.update(x);
            }
            if (option == 6) {
                System.out.println("All books are displayed");
                Query query = session.createQuery("from Book");
                List list = query.getResultList();
                System.out.println(list);
            }
            if (option == 7) {
                System.out.println("All authors are displayed by first and last name");
                Query query = session.createQuery("from Author where authorLastName=:lastNameDisplay and authorFirstName=:firstNameDisplay");

                Author authorDisplayed = (Author) query.getResultList().get(0);

                System.out.println(authorDisplayed);
            }
            if (option == 8) {
                System.out.println("The age and name of all the authors participating in the writing of the given book are displayed");
                System.out.println("Enter the book:");
                Scanner scanner1 = new Scanner(System.in);
                String inputDisplayBooks = scanner1.nextLine();
                Query query = session.createQuery("from Book where title=:titleName");
                query.setParameter("titleName", inputDisplayBooks);
                Book books = (Book) query.getResultList().get(0);
                System.out.println(books.getAuthors());

            }
            if (option == 9) {
                System.out.println("The publisher and the name of the books that belong to the action genre are displayed");
                Query query = session.createQuery("from Book where type=:typeDisplay ");
                query.setParameter("typeDisplay", "action");
                List<Book> list = (List<Book>) query.getResultList();
                for (Book item : list) {
                    String titleBook = item.getTitle();
                    String publishingHouseBook = String.valueOf(item.getPublishingHouseBooks());
                    System.out.println("The name of the book is:" + titleBook + "and the publishing house is:" + publishingHouseBook);
                }


            }
            if (option == 10) {
                System.out.println("The oldest book and the names of the authors and their exp are displayed");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter the year");
                Integer inputYearDisplay = scanner1.nextInt();
                Query query = session.createQuery("from Book where yearOfPublication<:yearDisplay");
                query.setParameter("yearDisplay", inputYearDisplay);
                Query query1 = session.createQuery("from Author where yearsOfExperience=:experienceDisplay");
                Author authorListResult = (Author) query1.getResultList().get(0);

                List<Book> booksListResult = (List<Book>) query.getResultList();
                for (Book item : booksListResult) {

                    String nume = String.valueOf(item.getAuthors());
                    Integer exp = authorListResult.getYearsOfExperience();
                    System.out.println("Names of authors:" + nume + "and their experience" + exp);


                }

            }
            if (option == 11) {
                System.out.println("Enter the publishing house you want to delete");
                Scanner scanner5 = new Scanner(System.in);
                String inputDeletePublishingHouse = scanner5.nextLine();
                Query query = session.createQuery("from PublishingHouse where PublishingHouseName=:deletePublishingHouse");
                query.setParameter("deletePublishingHouse", inputDeletePublishingHouse);
                List list = query.getResultList();
                session.delete(list.get(0));
                System.out.println("Publishing house was deleted");
            }
            if (option == 12) {
                System.out.println("Choose the book you want to borrow");
                Scanner scanner5 = new Scanner(System.in);
                String inputBookBorrow = scanner5.nextLine();
                Query query = session.createQuery("from Book where title =: bookBorrow");
                query.setParameter("bookBorrow", inputBookBorrow);
                List<Book> listResultBook = (List<Book>) query.getResultList();

                for (Book books : listResultBook) {
                    if (books.isStatus() == true) {
                        System.out.println("The book " + books.getTitle() + " is available to be borrowed.");
                    } else {
                        System.out.println("The book " + books.getTitle() + " is not available to be borrowed.");
                    }

                }

            }
            if (option == 13) {

                System.out.println("Insert the book you want to modify");
                Scanner scanner5 = new Scanner(System.in);
                String inputBookToModify = scanner5.nextLine();
                Query query = session.createQuery("from Book where title =:searchBook");
                query.setParameter("searchBook", inputBookToModify);
                Book listBookToModify = (Book) query.getResultList().get(0);
                System.out.println(listBookToModify + "The selected book has been found");


                Scanner scanner6 = new Scanner(System.in);
                System.out.println("Insert the author last name");
                String inputLastNameAuthorToModify = scanner6.nextLine();
                System.out.println("Insert the author first name");
                String inputFirstNameToModify = scanner6.nextLine();
                Query query1 = session.createQuery("from Author where authorLastName =:searchLastName and authorFirstName=:searchFirstName");
                query1.setParameter("searchLastName", inputLastNameAuthorToModify);
                query1.setParameter("searchFirstName", inputFirstNameToModify);
                Author listResultAuhorFirstAndLastName = (Author) query1.getResultList().get(0);
                System.out.println(listResultAuhorFirstAndLastName + "The author you selected was found");
                listBookToModify.getAuthors().add(listResultAuhorFirstAndLastName);
                session.persist(listBookToModify);


            }
            if (option == 14) {
                System.out.println("Chose the book you want to add a rating");
                Scanner scanner1 = new Scanner(System.in);
                String inputSearchBookByTitle = scanner1.nextLine();
                Query query = session.createQuery("from Book where title=:searchTitle");
                query.setParameter("searchTitle", inputSearchBookByTitle);
                Book listResulTitle = (Book) query.getResultList().get(0);
                System.out.println("Please add a review");
                String inputAddReviewToABook = scanner1.nextLine();
                System.out.println("Please add a star between 1 and 5");
                Integer inputAddStarToABook = scanner1.nextInt();
                ReviewAndStar reviewAndStar = new ReviewAndStar();
                reviewAndStar.setStars(inputAddStarToABook);
                reviewAndStar.setReview(inputAddReviewToABook);
                session.persist(reviewAndStar);


                listResulTitle.getReviewAndStars().add(reviewAndStar);

                session.save(listResulTitle);


            }
            if (option == 15) {
                System.out.println("To create an account you need to enter your name and a unique number or numbers");
                System.out.println("Insert your last name");
                Scanner scanner1 = new Scanner(System.in);
                String inputLastName = scanner1.nextLine();
                System.out.println("Insert your first name");
                String inputFirstName = scanner1.nextLine();
                System.out.println("Insert unique number");
                Integer inputUniqueID = scanner1.nextInt();
                System.out.println("Insert your gender");
                String inputGender = scanner1.nextLine();

                Person personClients = new Person();
                personClients.setPersonLastName(inputLastName);
                personClients.setPersonFirstName(inputFirstName);
                personClients.setIdIdentification(inputUniqueID);
                personClients.setGender(inputGender);
                session.persist(personClients);
            }
            if (option == 16) {
                System.out.println("Chose the book you want to borrow");
                Scanner scanner1 = new Scanner(System.in);
                String searchBook = scanner1.nextLine();
                Query query = session.createQuery("from Book where title=:searchBook");
                query.setParameter("searchBook", searchBook);
                Book bookFound = (Book) query.getResultList().get(0);
                System.out.println(bookFound + "was found");
                System.out.println("Enter your unique ID");
                Integer searchUniquePersonID = scanner1.nextInt();
                Query query1 = session.createQuery("from Person where idPersonC=:searchID");
                query1.setParameter("searchID", searchUniquePersonID);
                Person personClients = (Person) query1.getResultList().get(0);
                System.out.println(personClients + "was found");
                bookFound.getPersonClients().add(personClients);
                session.persist(bookFound);


            }

            System.out.println("Choose the option again");
            if (option != 17) {
                option = scanner.nextInt();
            }


        } while ((option != 17));
        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }
}

