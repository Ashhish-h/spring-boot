This is the proper file for crud operations including crud apis

working -
                                                       
                                                                        (Internally calls Repository which extends JpaRespository)     
                                                                                        |<------>Repository
                                                                                        |
    client---(send http request)--->Controller---(decides which service is to be called)---> Service---(it then perform operation on)--->Model(entity)
                                                                                        |                                                     |       
                                                                                        |--------->DataBase<-------------JPA/SpringData<------|

