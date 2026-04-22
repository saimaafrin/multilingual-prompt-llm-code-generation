
PLS=c("python","java")
MODELS=c("gpt","claude","deepseek")

for(PL in PLS){
  for(MODEL in MODELS){
    DIR="quantitative_analysis_report/"
    OUTDIR="stats/"
    metricsFile=paste(DIR,PL,"_",MODEL,"_report.csv",sep="")
    testFile=paste(DIR,PL,"_",MODEL,"_test_report.csv",sep="")
    
    t<-read.csv(metricsFile)
    
    if(PL=="python"){
      metrics<-c("nloc",
                 "ccn",
                 "Comment.Lines",
                 "Comment....",
                 "Cognitive.Complexity",
                 "Code.Smells",
                 "Bugs",
                 "Security.Hotspots",
                 "pylint",
                 "flake8")
    } else {
      metrics<-c("nloc",
                 "ccn",
                 "Comment.Lines",
                 "Comment....",
                 "Cognitive.Complexity",
                 "Code.Smells",
                 "Bugs",
                 "Security.Hotspots",
                 "pmd")
    }
    
    languages=c("chinese","hindi","spanish","italian")
    allLanguages=c("english",languages)
    
    #
    # metrics and warnings - friedman test
    #
    res=list()
    for(lang in allLanguages)
    {
      for(metric in metrics)
      {
        column=t[[paste(lang,metric,sep="_")]]
        f<-friedman.test(column,t$iter,t$id)$p.value
        res$language=c(res$language,as.character(lang))
        res$metric=c(res$metric,as.character(metric))
        res$p.value=c(res$p.value,f)
      }
    }
    res=data.frame(res)
    res$p.value=p.adjust(res$p.value,method="BH")
    res
    
    ##
    # metrics and warnings' analysis
    ##
    library(effsize)
    res=list()
    for(lang in languages)
    {
      for(metric in metrics)
      {
        res$language=c(res$language,lang)
        res$metric=c(res$metric,metric)
        c1=t[[paste("english",metric,sep="_")]]
        c2=t[[paste(lang,metric,sep="_")]]
        p.value=wilcox.test(c2,c1,paired=TRUE)$p.value
        res$p.value=c(res$p.value,p.value)
        res$signif=c(res$signif,FALSE)
        cd=cliff.delta(c2,c1,paired=TRUE)
        res$d=c(res$d,round(cd$estimate,2))
        res$magnitude=c(res$magnitude,as.character(cd$magnitude))
      }
    }
    res=data.frame(res)
    res$p.value=round(p.adjust(res$p.value,method="BH"),digits=4)
    res$signif=res$p.value<0.05
    
    res
    write.csv(res,file=paste(OUTDIR,PL,"-",MODEL,"-metrics.csv",sep=""),quote=FALSE,row.names = FALSE)
    
    #################
    # tests
    ####
    library(effectsize)
    t<-read.csv(testFile)
    
    #################
    # tests cochran q test
    ####
    
    library(rstatix)
    
    res=list()
    for(lang in allLanguages)
    {
      column=t[[paste(lang,"test",sep="_")]]
      p=cochran_qtest(t,t[[paste(lang,"test",sep="_")]]~iter|id)$p
      res$language=c(res$language,as.character(lang))
      res$p.value=c(res$p.value,p)
      
    }
    res=data.frame(res)
    res$p.value=p.adjust(res$p.value,method="BH")
    res
    
    
    #################
    # tests mcnemar
    ####
    res=list()
    for(lang in languages)
    {
      la=paste(lang,"test",sep="_")
      ta=table(t$english_test,t[[la]])
      passedEng=round(100*(ta[2,1]+ta[2,2])/sum(ta),digits=2)
      passedLang=round(100*(ta[1,2]+ta[2,2])/sum(ta),digits=2)
      p=mcnemar.test(ta)$p.value
      g=cohens_g(ta)$Cohens_g
      label=interpret_cohens_g(g)
      res$language=c(res$language,as.character(lang))
      res$passedEng=c(res$passedEng,passedEng)
      res$passedLang=c(res$passedLang,passedLang)
      res$p.value=c(res$p.value,p)
      res$signif=c(res$signif,FALSE)
      res$g=c(res$g,round(g,digits=4))
      res$magnitude=c(res$magnitude,label)
    }
    res=data.frame(res)
    res$p.value=round(p.adjust(res$p.value,method="BH"),digits=4)
    res$signif=res$p.value<0.05
    res
    write.csv(res,file=paste(OUTDIR,PL,"-",MODEL,"-test.csv",sep=""),quote=FALSE,row.names = FALSE)
  }
}

##
# RQ3 inter-rater agreement
##

t<-read.csv("agreement.csv")
t$language=as.factor(t$language)
t$comments_1=as.factor(t$comments_1)
t$comments_2=as.factor(t$comments_2)
t$identifiers_1=as.factor(t$identifiers_1)
t$identifiers_2=as.factor(t$identifiers_2)
t$literals_1=as.factor(t$literals_1)
t$literals_2=as.factor(t$literals_2)
levels(t$identifiers_1)=c("n","e","c","s","h","i")
levels(t$identifiers_2)=c("n","e","c","s","h","i")

lang=c("chinese","hindi","spanish","italian")
res=list()
for(l in lang)
{
  res$language=c(res$language,as.character(l))
  t1<-subset(t,t$language==as.character(l))
  library(psych)
  k=cohen.kappa(as.matrix(data.frame(v1=t1$identifiers_1,v2=t1$identifiers_2)))
  res$identifiers=c(res$identifiers,k$kappa)
  
  k=cohen.kappa(as.matrix(data.frame(v1=t1$comments_1,v2=t1$comments_2)))
  res$comments=c(res$comments,k$kappa)
  
  k=cohen.kappa(as.matrix(data.frame(v1=t1$literals_1,v2=t1$literals_2)))
  res$literals=c(res$literals,k$kappa)
}
res=data.frame(res)
res