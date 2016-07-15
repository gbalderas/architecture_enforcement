//Press F1 (help) for detailed info about the architecture DSL.

//Simple Model/View/Controller example.

//Create an artifact with a name
artifact Model
{
    //Specify an include pattern
    include "**/library/model/**"
}



//artifact ViewModel
//{
//    include "**/library/views/*ViewModel"
//    connect to Model
//}

//artifact View
//{
    //include "**/library/views/*View"
   // //Specify the allowed dependencies
 //   connect to ViewModel
//}
//

artifact MvvmViewModel{
     include "External **/de/saxsys/mvvmfx/ViewModel"   
}

artifact Business
{
    include "**/library/views/**"
    interface default{
        include dependency-types IMPLEMENTS
    }
    
    
    connect to MvvmViewModel
}


